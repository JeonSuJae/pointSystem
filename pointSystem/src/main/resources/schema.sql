DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Point;
DROP TABLE IF EXISTS UseHistory;

CREATE TABLE Users
(
    user_key      IDENTITY        PRIMARY KEY,
    max_point     BIGINT          NOT NULL ,
    balance       BIGINT          NOT NULL
);

CREATE TABLE Point
(
    point_key   IDENTITY        PRIMARY KEY,
    point       INT             NOT NULL ,
    manual      VARCHAR(1)      NOT NULL ,
    end_Date    DATETIME        NOT NULL ,
    use_yn      VARCHAR(1)      NOT NULL ,
    user_key    INT,
    FOREIGN KEY (user_key)
        REFERENCES Users(user_key) ON UPDATE CASCADE
);

CREATE TABLE UseHistory
(
    history_num IDENTITY    PRIMARY KEY,
    order_num   INT        NOT NULL ,
    point       INT             NOT NULL ,
    point_key    INT,
    FOREIGN KEY (point_key)
        REFERENCES Point(point_key) ON UPDATE CASCADE
);

