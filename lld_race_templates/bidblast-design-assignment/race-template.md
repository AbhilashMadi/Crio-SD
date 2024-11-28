# Top 10 Questions for Requirement Gathering

1. **What is the primary goal of this system?**

   - Understanding the core purpose, such as user engagement, driving app downloads, or increasing product sales.

2. **Who are the target users of this system?**

   - Clarifying demographics, technical familiarity, and their motivation to participate (e.g., rewards, entertainment).

3. **What are the rules for participation?**

   - Defining eligibility criteria, bid limits, and the cost (e.g., coins or credits) for submitting bids.

4. **What should happen when there are no unique bids?**

   - Establishing fallback mechanisms, like rolling over the prize or randomly selecting a winner.

5. **How are prizes defined and distributed?**

   - Understanding prize categories, quantities, distribution timelines, and if they are physical or digital.

6. **What analytics or insights should the system provide?**

   - Determining metrics like user participation, bid patterns, or daily engagement.

7. **What kind of user feedback is necessary?**

   - Identifying whether participants need live stats (e.g., total bids submitted) or post-event summaries (e.g., why they lost).

8. **What kind of notifications should the system send?**

   - Outlining event reminders, bid confirmations, result announcements, and prize claims.

9. **What are the failure scenarios and recovery plans?**

   - Planning for errors, such as system crashes or fraudulent bidding, and designing fallback solutions.

10. **What security measures are needed?**
    - Ensuring bid integrity, user privacy, and prize distribution safeguards against fraud.

##

# Rules and Mechanics for CRED Bid Blast

## **Participation Rules**

1. **Maximum Sets Per Event**:

   - A user can purchase up to **5 sets** for a single event.

2. **Cost of Sets**:

   - The price of each set increases incrementally:
     - **1st Set**: 100 coins
     - **2nd Set**: 500 coins
     - **3rd Set**: 1000 coins
     - **4th Set**: 1500 coins
     - **5th Set**: 2000 coins

3. **Bids Per Set**:

   - Each set contains **6 bids**.

4. **Number of Items Displayed**:
   - Each event features **one lavish item** as the prize.

---

## **Winning Mechanism**

1. **How the Winner is Decided**:

   - The **lowest unique bid** is declared the winner.

2. **What Happens If There’s No Lowest Unique Bid?**
   - The winner is decided based on the **earliest submission**:
     - If the lowest bid (e.g., **78**) is not unique (e.g., 3 members submitted it), the member who submitted their bid set **first** among those with the lowest bid wins.

---

## **Example Scenario**

- **Lowest Bid**: 78
- **Submitted by**:
  - Member A (submitted at 2:30 PM)
  - Member B (submitted at 2:45 PM)
  - Member C (submitted at 2:35 PM)
- **Winner**: Member A, because their bid set was submitted earliest among the members with the lowest bid.

<br/>
<br/>
<br/>

# R - Requirements

## **System-Level Capabilities**

1. **Add a New Event**:

   - The system should allow administrators to create a new bidding event.
   - Each event must be associated with a single lavish winning item (prize).

2. **Declare a Winner**:
   - The system should calculate and announce the winner based on the **lowest unique bid** mechanism.
   - If no unique bid exists, the winner is determined by the **earliest submission** of the lowest bid.

---

## **Member-Level Capabilities**

1. **Participate in an Event**:

   - Members should be able to join an ongoing event for a specific item.

2. **Buy Sets of Bids**:

   - Members can purchase up to **5 sets** of bids per event.
   - The cost of each additional set increases (in CRED coins).

3. **Submit a Set of Bids**:

   - Members can submit a set containing **6 bids** for the event.

4. **View Latest Winners**:
   - Members should be able to see a list of winners from recent past events.

---

<br/>
<br/>
<br/>

# A - APIs

```json

// ---------- Add New Event
/* Endpoint: POST /events */

/* request body */
{
   "eventName": "Bid for MacBook",
   "prize": "Apple MacBook Pro",
   "startTime": "2024-12-01T18:00:00",
   "endTime": "2024-12-02T15:00:00Z"
}

/* response */
{
   "eventId": "123abc",
   "message": "Event created Successfully"
}


// ----------- Buy Bid Set
/* Endpoint: POST /events/{eventId}/bids/buy

/* request body */
{
   "userId": "user123",
   "coinsUsed": 500,
}

/* response */
{
   "message": "Bid set purchased successfully",
   "setId": "set123"
}


// ------------ Submit Bids
/* Endpoint: POST /evnets/{eventId}/bids/submit */

{
   "userId": "user123",
   "setId": "set6787",
   "bids": [10, 20 , 30, 40, 50, 60]
}

/* response */
{
   "message": "Bids Submitted Successfully"
}


// --------- Declare Winner
/* Endpoint: POST /events/{eventId}/declare-winner */

{
   "eventId": "12345",
   "winner": {
      "userId": "user12345",
      "winngBid": 25
   }
}


//----------- Get Latest Winner
/* Endpoint: GET /events/latest-winners?date={optional} */


[
   {
      "eventId": "12345",
      "prize": "Apple Macbook Pro",
      "winner": {
         "userId": "user456",
         "winningBid": 25
      }
   }
]

```

---

# C - Classes (Entitys)

1. Event

   - Attributes
     - `eventId` Uniq identifier for the event
     - `eventName` Name of the event
     - `prize` Item for which user are bidding
     - `startTime` Event start time
     - `endTime` Event end time
     - `bids` List of all submitted bids

2. User

   - Attributes
     - `userId`
     - `name`
     - `bids`
     - `timestamp`

3. BidSet

   - Attributes
     - `setId`
     - `bids`
     - `timestamp`

4. Winner
   - Attributes
     - `eventId`
     - `userId`
     - `winningBid`

# E - Execution

# Bidding System Flow

```mermaid

    A[Adding a New Event] --> B[Buying a Bid Set]
    B --> C[Submitting Bids]
    C --> D[Declaring a Winner]
    D --> E[Viewing Latest Winners]

    A -->|Admin creates event with prize and times| B;
    B -->|Member buys up to 5 sets of bids| C;
    C -->|Member submits 6 bids per set| D;
    D -->|System checks lowest unique bid and declares winner| E;
    E -->|Members can view past winners and prizes| A;

```
