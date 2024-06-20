drop table product if exists;

create table product (
	id int auto_increment primary key,
	name varchar(100) not null,
	price int not null,
	image varchar(100) not null
);

insert into product values(1, 'まぐろ', 100, '1.jpg');
insert into product values(2, 'サーモン', 100, '2.jpg');
insert into product values(3, 'えび', 100, '3.jpg');
insert into product values(4, 'いか', 100, '4.jpg');
insert into product values(5, 'えんがわ', 100, '5.jpg');
insert into product values(6, 'あなご', 100, '6.jpg');
insert into product values(7, 'たまご', 100, '7.jpg');
insert into product values(8, 'ほたて', 100, '8.jpg');
insert into product values(9, '赤貝', 100, '9.jpg');
insert into product values(10, 'つぶ貝', 100, '10.jpg');
insert into product values(11, 'サラダ軍艦', 150, '11.jpg');
insert into product values(12, 'ねぎとろ軍艦', 150, '12.jpg');
insert into product values(13, 'ねぎとろ巻', 150, '13.jpg');
insert into product values(14, 'アボカド巻', 150, '14.jpg');
insert into product values(15, 'トロ', 200, '15.jpg');
insert into product values(16, 'いくら', 200, '16.jpg');
insert into product values(17, 'うに', 200, '17.jpg');