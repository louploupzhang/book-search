-- We are using PostgreSQL 17.5
-- CSV Header is below
-- bookId,title,author,rating,description,language,isbn,bookFormat,edition,pages,publisher,publishDate,firstPublishDate,likedPercent,price

-- Create the books table
CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    rating DECIMAL(2, 1),
    description TEXT,
    language VARCHAR(255),
    isbn VARCHAR(255) UNIQUE,
    book_format VARCHAR(255),
    edition VARCHAR(255),
    pages INTEGER,
    publisher VARCHAR(255),
    publish_date DATE,
    first_publish_date DATE,
    liked_percent DECIMAL(5, 2),
    price DECIMAL(5, 2)
);

-- Create the authors table
CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create the books_authors table
CREATE TABLE books_authors (
    book_id INTEGER NOT NULL,
    author_id INTEGER NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id),
    FOREIGN KEY (author_id) REFERENCES authors(author_id)
);