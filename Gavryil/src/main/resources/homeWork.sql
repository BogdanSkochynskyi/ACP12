
//Q1. Find the titles of all movies directed by Steven Spielberg.
SELECT
   *
FROM
   movies
WHERE
   director = 'Steven Spielberg';

//Q2. Find all years that have a movie that received a rating of 4 or 5, and sort them in increasing order.
   SELECT
      year
   FROM
      movies m
   LEFT JOIN
      ratings r
         ON m.mID = r.mID
   WHERE
      stars >= 4;

   //Q3. Find the titles of all movies that have no ratings.

    SELECT
       title
    FROM
       movies m
    LEFT JOIN
       ratings r
          ON m.mID = r.mID
    WHERE
       stars is NULL;

   // Q4. Some reviewers didn't provide a date with their rating.
    //Find the names of all reviewers who have ratings with a NULL value for the date.

    SELECT
       DISTINCT name
    FROM
       reviewers rv
    LEFT JOIN
       ratings ra
          ON rv.rID = ra.rID
    LEFT JOIN
       movies m
          ON ra.mID = m.mID
    WHERE
       ra.ratingDate is NULL;

     //Q5. Write a query to return the ratings data in a more readable format:
      reviewer name, movie title, stars, and ratingDate. Also, sort the data, first by reviewer name, then

    SELECT
       name AS 'reviewer name',
       movies.title AS 'movie title' ,
       ratings.stars,
       ratings.ratingDate
    FROM
       reviewers
    INNER JOIN
       ratings
          ON reviewers.rID = ratings.rID
    INNER JOIN
       movies
          ON movies.mID = ratings.mID
    ORDER BY
       reviewers.name ASC;

    //Q6*. For all cases where the same reviewer rated the same movie twice
    and gave it a higher rating the second time, return the reviewer's name and the title of the movie.

    SELECT
       DISTINCT
       name AS 'reviewer name',
       m.title AS 'movie title'
    FROM
       reviewers rew
    INNER JOIN
       ratings r
          ON rew.rID = r.rID
    INNER JOIN
       movies m
          ON m.mID = r.mID
    INNER JOIN
       ratings rat
          ON r.mID = rat.mID
    WHERE
       r.stars > rat.stars
       AND r.ratingDate > rat.ratingDate
    ORDER BY
       rew.name ASC;



    // Q7*. For each movie that has at least one rating,
     find the highest number of stars that movie received.
     Return the movie title and number of stars. Sort by movie title.

   SELECT
          m.title,
          MAX(r.stars)
       FROM
          movies m
       INNER JOIN
          ratings r
             ON m.mID = r.mID
    GROUP BY
       title;

    //Q8*. For each movie, return the title and the 'rating spread',
    that is, the difference between highest and lowest ratings given
    to that movie. Sort by rating spread from the highest to the lowest.

    SELECT
        movies.title,
        (MAX(ratings.stars) - MIN(ratings.stars)) AS res
    FROM
        ratings
            INNER JOIN
        movies ON movies.mID = ratings.mID
    GROUP BY movies.title
    ORDER BY res DESC;

