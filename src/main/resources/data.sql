insert into taux_change (id,date,dest,source,taux)
values(1001,'2018-06-24','EUR','USD',1.17);
insert into taux_change (id,date,dest,source,taux)
values(1002,'2018-06-24','EUR','JPY',130);
insert into taux_change (id,date,dest,source,taux)
values(1003,'2018-06-24','USD','GBP',0.75);

insert into operation_change (id,amount,ccy_src, ccy_dest, trn_taux, date)
values(1234,100,'AUD','COP',1.34,'2018-03-23');
