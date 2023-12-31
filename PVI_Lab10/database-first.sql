--create database JDBC;
use JDBC;

create table DiningRoom (
	Id int identity(1,1) PRIMARY KEY,
	Name nvarchar(255),
	Price float,
	Comment nvarchar(1024)
);

insert into DiningRoom (Name, Price, Comment) values
('Биточки куриные', 2.38 , 'Лучшая котлета в мире'),
('Свиная отбивная', 2.75 , 'Нормас котлета'),
('Тефтели свиные', 2.05, 'Бюджетно но вкусно'),
('Пюре картофельное', 1.23, 'Имба'),
('Макарошки', 1.05, 'Жесткая имба'),
('Борщ', 1.24, 'Мощная темка'),
('Рассольник', 0.95, 'Жесткий суп'),
('Булочка Витьба', 0.52, 'Бюджетно чисто похавать'),
('Пицца Школьная', 2.56, 'Раскошелиться на крутой обед');

create proc GetDishesByPriceRange
    @minPrice float,
    @maxPrice float
as
begin
    select 
		*
	from 
		DiningRoom 
	where 
		Price > @minPrice and
		Price < @maxPrice;
end;

select * from DiningRoom;
exec GetDishesByPriceRange 1, 2;