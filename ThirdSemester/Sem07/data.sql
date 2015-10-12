insert into auto_brands values(1, 'AC', '/cars/ac/');
insert into auto_brands values(2, 'Acura', /cars/acura/ );
insert into auto_brands values(3, 'Alfa Romeo', /cars/alfa-romeo/ );
insert into auto_brands values(4, 'Alpine', /cars/alpine/ );
insert into auto_brands values(5, 'AM General', /cars/am-general/ );
insert into auto_brands values(6, 'Ariel', /cars/ariel/ );
insert into auto_brands values(7, 'Aro', /cars/aro/ );
insert into auto_brands values(8, 'Asia', /cars/asia/ );
insert into auto_brands values(9, 'Aston Martin', /cars/aston-martin/ );
insert into auto_brands values(10, 'Audi' , /cars/audi/ );
insert into auto_brands values(11, 'Austin', /cars/austin/  );
insert into auto_brands values(12, 'Autobianchi' , /cars/autobianchi/ );
insert into auto_brands values(13, 'Baltijas Dzips', /cars/baltijas-dzips/  );
insert into auto_brands values(14, 'Beijing', /cars/beijing/ );
insert into auto_brands values(15, 'Bentley', /cars/bentley/ );

insert into auto_models values(140, '02 (E10)', 18, '/cars/bmw/02-e10/ ');
insert into auto_models values(141, '1er', 18), '/cars/bmw/1er/ ';
insert into auto_models values(142, '2er', 18, '/cars/bmw/2er/ ');
insert into auto_models values(143, '2er Active Tourer', 18, '/cars/bmw/2er-active-tourer/ ');
insert into auto_models values(144, '3er', 18, '/cars/bmw/3er/ ');
insert into auto_models values(145, '4er', 18, '/cars/bmw/4er/ ');
insert into auto_models values(146, '5er', 18, '/cars/bmw/5er/ ');
insert into auto_models values(147, '6er', 18, '/cars/bmw/6er/ ');
insert into auto_models values(148, '7er', 18, '/cars/bmw/7er/ ');

insert into auto_submodels values(314, NULL, 18, 140, '/cars/bmw/02-e10/');
insert into auto_submodels values(315, '1er II (F20-F21) ������� 5 ��.', 18, 141, '/cars/bmw/1er/ii/group-hatchback_5d/');
insert into auto_submodels values(316, '1er II (F20-F21) ������� 3 ��.', 18, 141, '/cars/bmw/1er/ii/group-hatchback_3d/');
insert into auto_submodels values(317, '1er I (E81-E88) ���������', 18, 141, '/cars/bmw/1er/i/group-cabrio/');


insert into auto_modify values (2591, '116i 1.6 AT (136 �.�.)', '1er II (F20-F21) ������� 5 ��. 116i 1.6 AT (136 �.�.)', 18, 141, 315, '������', '������', 2011, 0), '/cars/bmw/1er/ii/group-hatchback_5d/mod-19969/');
insert into auto_modify values (2592, '118i 1.6 AT (170 �.�.)', '1er II (F20-F21) ������� 5 ��. 116i 1.8 AT (170 �.�.)', 18, 141, 315, '������', '������', 2011, 0), '/cars/bmw/1er/ii/group-hatchback_5d/mod-19970/ ');
insert into auto_modify values (2593, '114i 1.6 �T (102 �.�.)', '1er II (F20-F21) ������� 5 ��. 116i 1.4 AT (102 �.�.)', 18, 141, 315, '������', '������', 2011, 0), '/cars/bmw/1er/ii/group-hatchback_5d/mod-87192/');
insert into auto_modify values (2594, '116i 1.6 �T (136 �.�.)', '1er II (F20-F21) ������� 5 ��. 116i 1.6 AT (136 �.�.)', 18, 141, 315, '������', '������', 2011, 0), '/cars/bmw/1er/ii/group-hatchback_5d/mod-87021/');


insert into auto_params values (101995, 1, 2, 3,'����� 2��');
insert into auto_params values (101996, 9, 8, 7,'������);
insert into auto_params values (101997, 11, 22, 31,'����������');
insert into auto_params values (101998, 44, 56, 778,'������');
insert into auto_params values (101999, 77, 27, 32,'��-80');

insert into auto_params_names values (55, '��� ������', 66, null);
insert into auto_params_names values (66, '��� ���', 67, null);
insert into auto_params_names values (77, '�������', 68, null);
insert into auto_params_names values (88, '������� �������', 69, null);


insert into auto_params_groups values (1005, '�����');
insert into auto_params_groups values (106, '�����');
insert into auto_params_groups values (1007, '���������');
insert into auto_params_groups values (1008, '���������');
insert into auto_params_groups values (1009, '���������');


insert into users values(1, 'Alex', 'qwerty', 'qwerty@gmail.com', 'Tatarstan', 'Alex', 'Kozlovsky', '01.01.1965', 5, 'M', 'BMW');
insert into users values(2, 'Peter', 'qwerty1', 'qwerty1@gmail.com', 'Tatarstan', 'Alex', 'Kozlovsky', '01.01.1996', 1, 'M', 'BMW');
insert into users values(3, 'Onotole', 'qwerty2', 'qwerty3@gmail.com', 'Tatarstan', 'Onotole', 'Unknown', '01.01.1955', 5, 'M', 'Bentley');