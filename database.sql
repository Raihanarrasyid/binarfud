CREATE TABLE
    users (
        id serial PRIMARY KEY,
        username text NOT NULL,
        email text NOT NULL,
        password text NOT NULL
    );

CREATE TABLE
    merchants (
        id serial PRIMARY KEY,
        name text NOT NULL,
        location text NOT NULL,
        open boolean NOT NULL
    );

CREATE TABLE
    orders (
        id serial PRIMARY KEY,
        time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
        destination_address text NOT NULL,
        completed boolean NOT NULL DEFAULT FALSE,
        user_id integer REFERENCES users (id)
    );

CREATE TABLE
    products (
        id serial PRIMARY KEY,
        name text NOT NULL,
        price integer NOT NULL,
        merchant_id integer REFERENCES merchants (id)
    );

CREATE TABLE
    order_details (
        id serial PRIMARY KEY,
        order_id integer REFERENCES orders (id),
        product_id integer REFERENCES products (id),
        quantity integer NOT NULL
    );

select * from users;