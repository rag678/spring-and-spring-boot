insert into user_details(id,birth_date,name)
values(80,current_date(),'deepak');
insert into user_details(id,birth_date,name)
values(81,current_date(),'Rohit');
insert into user_details(id,birth_date,name)
values(82,current_date(),'Soham');

insert into post(id,description,user_id)
values(50,'I want to learn AWS',80);
insert into post(id,description,user_id)
values(51,'I want to learn devops',80);
insert into post(id,description,user_id)
values(52,'I want to learn JAVA',81);
insert into post(id,description,user_id)
values(53,'I want to learn C++',81);

insert into todo(done,id,target_date,description,username)
values(false,5000,CURRENT_DATE(),'I want to learn AWS','in28minutes');

insert into todo(done,id,target_date,description,username)
values(false,5001,CURRENT_DATE(),'I want to learn AWS','in28minutes');
insert into todo(done,id,target_date,description,username)
values(false,5002,CURRENT_DATE(),'I want to learn AWS','in28minutes');

--insert into user_details(id,birth_date,name)
--values(4,current_date(),"Awaz");