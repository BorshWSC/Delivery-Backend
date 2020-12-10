insert into category(id, name) values (1, 'Супы');
insert into category(id, name) values (2, 'Вок на лапше');
insert into category(id, name) values (3, 'Вок на рисе');
insert into category(id, name) values (4, 'Салаты');
insert into category(id, name) values (5, 'Напитки');


insert into image(id, link) values (1, 'assets/img/fo-bo.webp');
insert into image(id, link) values (2, 'assets/img/fo-ga.webp');
insert into image(id, link) values (3, 'assets/img/wok-n-chicken.webp');
insert into image(id, link) values (4, 'assets/img/wok-n-sea.webp');
insert into image(id, link) values (5, 'assets/img/wok-r-v.webp');
insert into image(id, link) values (6, 'assets/img/wok-r-meat.webp');
insert into image(id, link) values (7, 'assets/img/salad-chicken.webp');
insert into image(id, link) values (8, 'assets/img/salad-meat.webp');
insert into image(id, link) values (9, 'assets/img/ice-tea.webp');
insert into image(id, link) values (10, 'assets/img/mango-shake.png');

insert into dish(id, cost, description, name, weight, category_id, image_id)
values (1, 229, 'Бульон из говядины, говядина, рисовоя лапша. Подается с острым соусом', 'Фо Бо', 500, 1, 1);
insert into dish(id, cost, description, name, weight, category_id, image_id)
values (2, 290, 'Бульон из говядины, филе, рисовоя лапша. Подается с острым соусом', 'Фо Га', 1000, 1, 2);
insert into dish(id, cost, description, name, weight, category_id, image_id)
values (3, 269, 'Пшеничная лапша, куриное филе, огурец. Подается с имбирным соусом', 'Вок с курицей', 300, 2, 3);
insert into dish(id, cost, description, name, weight, category_id, image_id)
values (4, 269, 'Пшеничная лапша, мидии, огурец. Подается с имбирным соусом', 'Вок с мидиями', 300, 2, 4);
insert into dish(id, cost, description, name, weight, category_id, image_id)
values (5, 219, 'Рис, морковь, огурец. Подается с соусом тонкацу', 'Вок с овощами', 300, 3, 5);
insert into dish(id, cost, description, name, weight, category_id, image_id)
values (6, 269, 'Рис, говядина, огурец. Подается с устричным соусом', 'Вок с говядиной', 300, 3, 6);
insert into dish(id, cost, description, name, weight, category_id, image_id)
values (7, 159, 'Куриное филе, капуста, морковь. Подается с соевым соусом', 'Салат с курицей', 150, 4, 7);
insert into dish(id, cost, description, name, weight, category_id, image_id)
values (8, 159, 'Говядина, огурец, морковь. Подается с соевым соусом', 'Салат с говядиной', 140, 4, 8);
insert into dish(id, cost, description, name, weight, category_id, image_id)
values (9, 165, 'Смесь тайских чаев со льдом', 'Айс Ти по-тайски', 450, 5, 9);
insert into dish(id, cost, description, name, weight, category_id, image_id)
values (10, 300, 'Шейк из свежего манго со льдом', 'Манго-Шейк', 450, 5, 10);