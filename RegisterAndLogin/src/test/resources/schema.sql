drop table if exists tbl_user;
CREATE TABLE tbl_user(
    id int auto_increment,
    username VARCHAR(50),
    password VARCHAR(256)
);
INSERT INTO tbl_user(username, password) VALUES
    ('000001', 'a@b.c' ),
    ('000002', 'b@b.c' ),
    ('000003', 'c@b.c' ),
    ('000004', 'd@b.c' );