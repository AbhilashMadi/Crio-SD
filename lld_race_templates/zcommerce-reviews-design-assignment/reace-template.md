## R \_ Requirements

The system allow users to:
1 - Add reviews and ratings for product
2 - Upvote/Downvote existing reviews
3 - View summary of product ratings
4 - Fetch reviews sorted by:
-- Most Helpful(based on upvote)
-- Most recent
-- Positive First(highest ratings)
-- Negative First(lowest ratings)

## A \_ APIs

- Add a review & Rating

```json
// Endpoint: POST /products/{productId}/reviews

/* request body */
{
  "userId": "string",
  "rating": 4, // Integer (1-5)
  "reviewText": "string"
}

/* response */
{
  "reviewId": "string",
  "message": "Review added successfully."
}
```

- Upvote / Downvote a review

```json
// Endpoint: PATCH /reviews/{reviewId}/vote

/* request body */
{
  "userId": "string",
  "voteType": "upvote" // or "downvote"
}

/* response */
{
  "message": "Vote registered successfully.",
  "upvotes": 10,
  "downvotes": 2
}
```

- Get summary of ratings

```json
// Endpoint: GET /products/{productId}/ratings-summary

/* response */
{
  "productId": "string",
  "averageRating": 4.2,
  "ratingsCount": {
    "1": 12,
    "2": 20,
    "3": 45,
    "4": 88,
    "5": 150
  }
}
```

- Fetch review for a product

```json
// Endpoint: GET /products/{productId}/reviews

/*
 Query Parameters:
 sort: most-helpful, most-recent, positive-first, negative-first
 limit: Number of reviews per page (optional).
*/

/* response */
{
  "productId": "string",
  "reviews": [
    {
      "reviewId": "string",
      "userId": "string",
      "rating": 5,
      "reviewText": "Amazing product!",
      "upvotes": 12,
      "downvotes": 1,
      "createdAt": "2023-01-15T10:30:00Z"
    }
  ]
}
```

## C \_ Classes(Entities)

- The system require the following entities with relationships

  1.User

  - Atrributes
    - `userId` (primary key)
    - `name`
    - `email`

  2.Product

  - Attributes
    - `productId` (primary key)
    - `name`
    - `description`
    - `category`

  3.Review

  - Attributes
    - `reviewId` (primary key)
    - `productId` (primary key)
    - `userId` (foreign key)
    - `rating`
    - `reviewText`
    - `upvote`
    - `downvote`
    - `createdAt`

  4.Ratings Summary (derived entity for analytics)

  - Attributes
    - `productId` (foreign key)
    - `averageRating`
    - `ratingsCount` (1-5 rating breakdown)

## E \_ Execution

```sql

CREATE TABLE USERS{
  userId VARCHAR(255) PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255) UNIQUE
}

CREATE TABLE PRODUCTS {
  productId VARCHAR(255) PRIMARY KEY,
  name VARCHAR(255),
  description TEXT,
  category VARCHAR(255)
}

CREATE TABLE REVIEWS{
  reviewId VARCHAR(255) PRIMARY KEY,
  productId VARCHAR(255),
  userId VARCHAR(2555),
  rating INT CHECK (rating BETWEEN 1 AND 5),
  reviewText TEXT,
  upvotes INT DEFAULT 0,
  downvote INT DEFAULT 0,
  createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (productId) REFERENCES Products(productId),
  FOREGIN KEY (userId) REFERENCES Users(userId)
}
```
