DROP TABLE IF EXISTS info;
DROP TABLE IF EXISTS city;

CREATE TABLE city(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25) NOT NULL
);

CREATE TABLE info(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    city_id   INT NOT NULL,
    city_info VARCHAR(300) NOT NULL,
    FOREIGN KEY(city_id) REFERENCES city (id) ON DELETE CASCADE
);

INSERT INTO city(name) VALUES
    ('рио-де-жанейро'),
    ('петра'),
    ('рим'),
    ('гавана'),
    ('ватикан'),
    ('токио'),
    ('мехико'),
    ('сингапур'),
    ('будапешт'),
    ('бангкок');

INSERT INTO info(city_id, city_info) VALUES
    (1, 'От всемирно известного карнавала до культовых мест, Рио-де-Жанейро – это источник впечатлений для всех пяти ' ||
        'органов чувств. И здесь находятся два самых известных пляжа на Земле!'),
    (2, 'Петра выделяется среди всех величественных древних городов мира. Чтобы поверить в существование этих эпических,' ||
        ' открытых ветрам пустыни монументальных зданий, вырезанных в скалах, их нужно увидеть своими глазами.'),
    (3, 'Прогулки по Риму похожи на изучение огромного музея под открытым небом. Ни одно место на Земле не вмещает ' ||
        'такого обилия изобразительного искусства, кухни и массы древней истории как Вечный город.'),
    (4, 'Прогулка улицами Старой Гаваны это путешествие в прошлое, в мир величественных дореволюционных зданий и ' ||
        'классических автомобилей, в атмосферу, наполненную запахом домашней кухни вперемешку с морским бризом.'),
    (5, 'Ватикан это город-государство и центр Римско-католической церкви. Даже если вы нерелигиозный турист, достаточно ' ||
        'одного взгляда на колонны и купол площади Святого Петра, чтобы у вас перехватило дыхание.'),
    (6, 'Оказавшись в Токио, вы почувствуете себя перемещённым в будущее. Этот сверкающий мегаполис с 13 000 000 жителей' ||
        ' стал Меккой для шопоголиков, гурманов и тусовщиков. И вместе с тем в нём по-прежнему остаётся место для ' ||
        'умиротворяющих садов и святынь.'),
    (7,'В Мехико вас ждёт восхитительный микс достопримечательностей, звуков и цветов. Город с населением более 20 ' ||
       'миллионов человек, красивой колониальной архитектурой, близким расположением руин и основательной кухней.'),
    (8, 'Будь то отпуск или деловая поездка, пребывая в Сингапуре, непременно посетите его квартал Маленькая Индия. ' ||
         'Здесь вы найдёте лучшую уличную еду во всём мире.'),
    (9, 'Бесчисленные империи, которые правили Будапештом на протяжении многих лет, оставили свой след в этом городе, ' ||
         'который многие считают самым красивым в Европе. Добавьте ко всему шумные ночные клубы и множество термальных ' ||
         'источников – отличное путешествие гарантировано.'),
    (10, 'Бангкоку есть что предложить всем и каждому: от мирных храмов до экзотических рынков и шумных ночных клубов. ' ||
         'Он стал настолько популярен, что в 2013 году побил Лондон как самый посещаемый город!');