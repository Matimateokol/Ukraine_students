create database Ukraina_Uczniowie
use Ukraina_Uczniowie

--wykorzystaæ sql import manager, szukaj import w pasku startu, bierzesz plik excela bo formatowanie, zmieni³em 3 ostatnie kolumny na int, ale to nie ma za du¿ego znaczenia

select * from Uczniowie_uchodzcy_z_Ukrainy_be$
--zmiana nazwy
exec sp_rename 'Uczniowie_uchodzcy_z_Ukrainy_be$', 'Ukraina_Uczniowie'
select * from Ukraina_Uczniowie
--tworzenie kopii
select * into Ukraina_Uczniowie_kopia from Ukraina_Uczniowie
select * into Ukraina_Uczniowie_kopia2 from Ukraina_Uczniowie
select * into Ukraina_Uczniowie_odczyt from Ukraina_Uczniowie
go
--tworzenie usera do odczytu, nie potrzebne uprawnienia do selecta 
create login UserOdczyt with password='haslo123'
go
create user UserOdczyt for login UserOdczyt
go

--dodanie identity
alter table Ukraina_Uczniowie
add ID int Identity(1,1) not null
go
alter table Ukraina_Uczniowie
add constraint pk_uczniowie_ID primary key(ID)

--zmiana nazw kolumn na cos bardziej znosnego
exec sp_rename 'Ukraina_Uczniowie.Województwo', 'Wojewodztwo'
exec sp_rename 'Ukraina_Uczniowie.Publicznoœæ', 'Publicznosc'
exec sp_rename 'Ukraina_Uczniowie.[Typ podmiotu]', 'TypPodmiotu'
exec sp_rename 'Ukraina_Uczniowie.[Liczba szkó³]', 'LiczbaSzkol'
exec sp_rename 'Ukraina_Uczniowie.[Liczba uczniów uchodŸców z Ukrainy]', 'Ukraincy'
exec sp_rename 'Ukraina_Uczniowie.[w tym z dodatkow¹ bezp³atn¹ nauk¹ jêzyka polskiego]', 'NaukaPolskiego'


select * from Ukraina_Uczniowie where idTypPodmiotu=3 and idTerytPowiat=2212
select distinct idPublicznosc from Ukraina_Uczniowie
select * from Ukraina_Uczniowie where idPublicznosc=5
select distinct idTerytPowiat, Powiat from Ukraina_Uczniowie
--PROCEDURY TESTOWE
go
create procedure pokaz_powiat
@idTerytPowiat float
as
begin
	select * from Ukraina_Uczniowie where  idTerytPowiat=@idTerytPowiat
end

go
exec pokaz_powiat 2212

go

create procedure pokaz_powiat_0
@idTerytPowiat float, @idPublicznosc float
as
begin
	if @idTerytPowiat=0 and @idPublicznosc=0
	begin
		select * from Ukraina_Uczniowie
	end
	else if @idTerytPowiat=0
	begin
		select * from Ukraina_Uczniowie where  idPublicznosc=@idPublicznosc
	end
	else if @idPublicznosc=0
	begin
		select * from Ukraina_Uczniowie where  idTerytPowiat=@idTerytPowiat
	end
	else
	begin
		select * from Ukraina_Uczniowie where  idTerytPowiat=@idTerytPowiat and idPublicznosc=@idPublicznosc
	end
end

go
drop procedure pokaz_powiat_0
exec pokaz_powiat_0 201,1

go
--PROCEDURA SELECT WSZYSTKO z parametrami 
create procedure pokaz_szkoly_all
@idTerytWojewodztwo float, @idTerytPowiat float, @idPublicznosc float,  @idTypPodmiotu float
as
begin
	if @idTerytWojewodztwo=0 and @idTerytPowiat=0 and @idPublicznosc=0 and @idTypPodmiotu=0
		begin
			select * from Ukraina_Uczniowie
		end
	else if @idTerytWojewodztwo=0 and @idTerytPowiat=0 and @idPublicznosc=0
		begin
			select * from Ukraina_Uczniowie where  idTypPodmiotu=@idTypPodmiotu
		end
	else if @idTerytWojewodztwo=0 and @idTerytPowiat=0 and @idTypPodmiotu=0
		begin
			select * from Ukraina_Uczniowie where  idPublicznosc=@idPublicznosc
		end
	else if @idTerytWojewodztwo=0 and @idTypPodmiotu=0 and @idPublicznosc=0
		begin
			select * from Ukraina_Uczniowie where  idTerytPowiat=@idTerytPowiat
		end
	else if  @idTerytPowiat=0 and @idPublicznosc=0 and @idTypPodmiotu=0
		begin
			select * from Ukraina_Uczniowie where  idTerytWojewodztwo=@idTerytWojewodztwo
		end
	else if @idTerytWojewodztwo=0 and @idTerytPowiat=0
		begin
			select * from Ukraina_Uczniowie where  idTypPodmiotu=@idTypPodmiotu and idPublicznosc=@idPublicznosc
		end		
	else if @idTerytWojewodztwo=0 and @idPublicznosc=0
		begin
			select * from Ukraina_Uczniowie where  idTypPodmiotu=@idTypPodmiotu and idTerytPowiat=@idTerytPowiat
		end
	else if @idTerytWojewodztwo=0 and @idTypPodmiotu=0
		begin
			select * from Ukraina_Uczniowie where  idTerytPowiat=@idTerytPowiat and idPublicznosc=@idPublicznosc
		end
	else if @idTerytPowiat=0 and @idPublicznosc=0
		begin
			select * from Ukraina_Uczniowie where  idTypPodmiotu=@idTypPodmiotu and idTerytWojewodztwo=@idTerytWojewodztwo
		end
	else if @idTerytPowiat=0 and @idTypPodmiotu=0
		begin
			select * from Ukraina_Uczniowie where  idPublicznosc=@idPublicznosc and idTerytWojewodztwo=@idTerytWojewodztwo
		end
	else if @idPublicznosc=0 and @idTypPodmiotu=0
		begin
			select * from Ukraina_Uczniowie where  idTerytPowiat=@idTerytPowiat and idTerytWojewodztwo=@idTerytWojewodztwo
		end
	else if @idTerytWojewodztwo=0
		begin
			select * from Ukraina_Uczniowie where  idTypPodmiotu=@idTypPodmiotu and idPublicznosc=@idPublicznosc and idTerytPowiat=@idTerytPowiat
		end
	else if @idTerytPowiat=0 
		begin
			select * from Ukraina_Uczniowie where idPublicznosc=@idPublicznosc and idTypPodmiotu=@idTypPodmiotu and idTerytWojewodztwo=@idTerytWojewodztwo
		end			
	else if @idPublicznosc=0 
		begin
			select * from Ukraina_Uczniowie where idTerytPowiat=@idTerytPowiat and idTypPodmiotu=@idTypPodmiotu and idTerytWojewodztwo=@idTerytWojewodztwo
		end	
	else if @idTypPodmiotu=0 
		begin
			select * from Ukraina_Uczniowie where idPublicznosc=@idPublicznosc and idTerytPowiat=@idTerytPowiat and idTerytWojewodztwo=@idTerytWojewodztwo
		end
	else
		begin
			select * from Ukraina_Uczniowie where idTerytWojewodztwo=@idTerytWojewodztwo and idTerytPowiat=@idTerytPowiat and idPublicznosc=@idPublicznosc and idTypPodmiotu=@idTypPodmiotu
		end
end
grant exec on pokaz_szkoly_all to UserOdczyt
deny exec on pokaz_szkoly_all to UserOdczyt
exec pokaz_szkoly_all 20,0,0,0
go
--PROCEDURA SELECT DLA WOJEWODZTW

create procedure pokaz_wojewodztwo
@idTerytWojewodztwo float
as
begin
		select distinct idTerytWojewodztwo, Wojewodztwo, idTerytPowiat, Powiat from Ukraina_Uczniowie where idTerytWojewodztwo=@idTerytWojewodztwo
end

grant exec on pokaz_wojewodztwo to UserOdczyt

drop procedure pokaz_wojewodztwo
exec pokaz_wojewodztwo 2

--PROCEDURA SELECT DLA LIST FRONTENDOWYCH

create procedure pokaz_wojewodztwo
@idTerytWojewodztwo float
as
begin
	if @idTerytWojewodztwo=0
		begin
			select * from Ukraina_Uczniowie u
			inner join (select MIN(ID) as maxID from Ukraina_Uczniowie
			group by idTerytPowiat )
			ma on  ma.maxID=u.ID
			order by 1
		end
	else
		begin
			select * from Ukraina_Uczniowie u
			inner join (select MIN(ID) as maxID from Ukraina_Uczniowie
			where idTerytWojewodztwo=@idTerytWojewodztwo  group by idTerytPowiat )
			ma on  ma.maxID=u.ID
			order by 1
		end
end
go

create procedure lista_wojewodztwo
as
select * from Ukraina_Uczniowie u
inner join (select MIN(ID) as maxID from Ukraina_Uczniowie  group by idTerytWojewodztwo )
ma on  ma.maxID=u.ID
order by 1
go

create procedure lista_publicznosc
as
select * from Ukraina_Uczniowie u
inner join (select MIN(ID) as maxID from Ukraina_Uczniowie  group by idPublicznosc )
ma on  ma.maxID=u.ID
order by 1
go

create procedure lista_typ
as
select * from Ukraina_Uczniowie u
inner join (select MIN(ID) as maxID from Ukraina_Uczniowie  group by idTypPodmiotu )
ma on  ma.maxID=u.ID
order by 1
go

grant exec on lista_wojewodztwo to UserOdczyt
grant exec on lista_publicznosc to UserOdczyt
grant exec on lista_typ to UserOdczyt
grant exec on pokaz_wojewodztwo to UserOdczyt



--TABELA USER
use Ukraina_Uczniowie

CREATE TABLE users (
id int PRIMARY KEY,
active BIT,
roles varchar(255),
usersName varchar(255),
password varchar(50)    --trzeba przejœæ do users -> Design -> i zmienic passwor na password
)
insert into users values (
1,'1','ROLE_USER','username','pass'
)


select * from users