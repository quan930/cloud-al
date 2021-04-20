create table book
(
    book_id       bigserial   not null
        constraint book_pk
            primary key,
    book_name     varchar(50) not null,
    book_author   varchar(50) not null,
    is_deleted    int4        NOT NULL DEFAULT 0
);

comment on table book is '书籍';
comment on column book.book_id is '书籍id';
comment on column book.book_name is '书籍名称';
comment on column book.book_author is '作者';
comment on column book.is_deleted is '逻辑删除';


create table category
(
    category_id   bigserial   not null
        constraint category_pk
            primary key,
    category_name varchar(50) not null,
    book_id       int8,
    is_deleted    int4        NOT NULL DEFAULT 0
);
comment on table category is '类别';
comment on column category.category_id is '类别id';
comment on column category.category_name is '类别名';
comment on column category.is_deleted is '逻辑删除';
comment on column category.book_id is '书籍id';