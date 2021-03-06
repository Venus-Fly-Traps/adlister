USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ads_categories;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE TABLE categories (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       name varchar(50) NOT NULL,
                       primary key (id)
);

CREATE TABLE ads_categories (
                            ad_id int UNSIGNED NOT NULL,
                            category_id int UNSIGNED NOT NULL,
                            FOREIGN KEY (ad_id) REFERENCES categories(id),
                            FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE ads_users (
                           ad_id int UNSIGNED NOT NULL,
                           user_id int UNSIGNED NOT NULL,
                           FOREIGN KEY (ad_id) REFERENCES users(id),
                           FOREIGN KEY (user_id) REFERENCES users(id)

);


