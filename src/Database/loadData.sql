USE SuiviServiceEtudiants;

insert into etudiant values(150,'S155577884','Alaoui','Samir','celibataire','marocaine','2000-05-06','masculin','rue al houria nr 9 casablanca',20000,'casablanca',30,0788554466,'samir00@gmail.com',444455551111222288954687,'R114455','Alaoui','Saad','1960-04-23',null,'BK45789','Salami','Amina','1970-09-25',null);
insert into etudiant values(152,'S155579084','Sliman','Farah','celibataire','marocaine','2000-08-26','feminin','rue bnou hazm nr 5 oujda',60020,'oujda',30,0654789623,'farahsliman@gmail.com',444455551114687528954687,'BK45869','Sliman','Amine','1965-12-24',null,'BK45741','Sallam','Alia','1970-07-25',null);
insert into etudiant values(154,'R157899084','Drissi','Sanaa','celibataire','marocaine','1999-09-26','feminin','rue adarissa nr 122 rabat',10000,'rabat',50,0655220013,'sanaa99@gmail.com',778855545114687132654687,'R545869','Drissi','Said','1960-12-26',null,'R645741','Snini','Bouchra','1975-11-25',null);
insert into etudiant values(156,'S446523695','Zaalami','Inass','celibataire','marocaine','2000-07-25','feminin','rue maarif nr 32 al hoceima',45000,'al hoceima',50,0612226590,'inasinas@gmail.com',150032658899456321741325,'R23335','Zaalami','Mohammed','1960-07-01',null,'R48979','Mortazik','Saida','1975-01-25',null);
insert into etudiant values(158,'A455523698','Sliman','Mohammed','celibataire','marocaine','1999-09-27','masculin','rue bnou hazm nr 5 oujda',60020,'oujda',50,0655498306,'mohsliman@gmail.com',444465983126549713569874,'BK45869','Sliman','Amine','1965-12-24',null,'BK45741','Sallam','Alia','1970-07-25',null);
insert into etudiant values(160,'A551123659','Lahboub','Mohammed','celibataire','marocaine','2000-10-27','masculin','rue bnou hazm nr 10 oujda',60020,'oujda',50,0741803062,'lahboubmo@gmail.com',236465983126549445869874,'B458794','Lahboub','Amine','1970-11-14','2020-05-11','BK78496','Karami','Nisma','1970-10-25',null);

insert into etablissement values(10050,'casablanca',30);
insert into etablissement values(10052,'casablanca',30);
insert into etablissement values(10054,'rabat',50);
insert into etablissement values(10056,'rabat',50);
insert into etablissement values(10058,'rabat',50);
insert into etablissement values(10060,'rabat',50);
insert into etablissement values(10062,'tanger',70);
insert into etablissement values(10064,'tanger',50);
insert into etablissement values(10066,'agadir',60);
insert into etablissement values(10068,'agadir',70);
insert into etablissement values(10070,'oujda',70);

insert into filiere values(10050,200,'casablanca');
insert into filiere values(10050,210,'casablanca');
insert into filiere values(10050,220,'casablanca');
insert into filiere values(10052,202,'casablanca');
insert into filiere values(10054,204,'rabat');
insert into filiere values(10056,206,'rabat');
insert into filiere values(10058,208,'rabat');
insert into filiere values(10060,212,'rabat');
insert into filiere values(10062,214,'tanger');
insert into filiere values(10064,216,'tanger');
insert into filiere values(10066,218,'agadir');
insert into filiere values(10068,222,'agadir');
insert into filiere values(10070,224,'oujda');

insert into inscription values(150,10050,200,'2020-09-10');
insert into inscription values(152,10052,202,'2020-09-10');
insert into inscription values(154,10056,206,'2020-09-15');
insert into inscription values(156,10062,214,'2020-09-15');
insert into inscription values(158,10066,218,'2020-09-10');
insert into inscription values(160,10050,210,'2020-09-10');

insert into servicesetud values(150,2020,50,1000,30,70);
insert into servicesetud values(152,2020,52,1000,32,70);
insert into servicesetud values(154,2020,54,1000,34,70);
insert into servicesetud values(156,2020,56,1010,36,70);
insert into servicesetud values(158,2020,58,1000,38,72);
insert into servicesetud values(160,2020,60,1010,40,74);