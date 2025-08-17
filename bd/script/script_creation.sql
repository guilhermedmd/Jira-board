create database Board_Project;
use Board_project;
drop database board_project;
create table board(
id_board int auto_increment,
name varchar(90),
creation_data datetime default current_timestamp,
primary key(id_board)
);

create table block_card(
id_block int auto_increment,
is_blocked tinyint not null,
block_reason varchar (255) default null,
unblock_reason varchar (255) default null,
primary key (id_block)
);

create table column_board(
id_column int auto_increment,
name varchar(90),
position int,
type varchar(45),
id_board_fk int,
primary key(id_column),
foreign key (id_board_fk) references board(id_board) on delete cascade
);

create table card(
id_card int auto_increment,
task varchar(90),
description varchar(255),
creation_date datetime default current_timestamp,
last_column int,
id_column_fk int,
id_block_fk int,
primary key(id_card),
foreign key (id_column_fk) references column_board(id_column) on delete cascade,
foreign key(id_block_fk)references block_card(id_block) on delete cascade
);

delimiter &&
create procedure prc_change_card_column(card_id int, new_column_id int)
begin
declare last_column_id int;
select id_column_fk into last_column_id from card where id_card = card_id; 
update card set id_column_fk = new_column_id, last_column = last_column_id where id_card = card_id;
end &&
delimiter ;


delimiter &&
create procedure pcr_change_column_in_block(card_id int)
begin
declare last_column_id int;
declare id_block_column int;
if((select b.is_blocked from block_card b inner join card c on b.id_block = c.id_block_fk where c.id_card = card_id) > 0) then
	select id_column into id_block_column from column_board c inner join board b on c.id_board_fk = b.id_board where c.name = "Bloqueados";
	select id_column_fk into last_column_id from card where id_card = card_id; 
	update card set id_column_fk = id_block_column, last_column = last_column_id where id_card = card_id;
else
	select last_column into last_column_id from card where id_card = card_id; 
	update card set id_column_fk = last_column_id where id_card = card_id;
end if;

end &&
delimiter ;

select * from board;
select * from card;
select * from block_card;
select * from column_board;
select * from block_card;