INSERT INTO book (id, title, author, publisher, publication_year, description, category, isbn) VALUES
  (1, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Scribner', 1925, 'A história do milionário Jay Gatsby e sua paixão pela bela Daisy Buchanan.', 'Romance', '9781781396834'),
  (2, 'To Kill a Mockingbird', 'Harper Lee', 'J. B. Lippincott & Co.', 1960, 'A história de Atticus Finch, advogado em uma pequena cidade do Alabama, que defende um homem negro injustamente acusado de estupro.', 'Drama', '9780060935467'),
  (3, '1984', 'George Orwell', 'Secker and Warburg', 1949, 'Um clássico da literatura distópica, que apresenta um futuro sombrio controlado pelo governo totalitário de Big Brother.', 'Ficção científica', '9780141036144'),
  (4, 'Pride and Prejudice', 'Jane Austen', 'T. Egerton, Whitehall', 1813, 'A história das cinco irmãs Bennet e sua busca por casamento em uma sociedade patriarcal do século XIX.', 'Romance', '9781986936478'),
  (5, 'The Lord of the Rings', 'J.R.R. Tolkien', 'Allen & Unwin', 1954, 'Uma saga épica de fantasia que narra a jornada do hobbit Frodo e seus companheiros em busca de destruir o Um Anel e derrotar o malvado Sauron.', 'Fantasia', '9780345339706');



-- Inserts para a tabela book_copy
INSERT INTO book_copy (id, book_id, borrowed, reserved)
VALUES
  (1, 1, false, false),
  (2, 1, false, false),
  (3, 1, false, false),
  (4, 2, false, false),
  (5, 3, false, false),
  (6, 3, false, false),
  (7, 3, false, false),
  (8, 4, false, false),
  (9, 5, false, false),
  (10, 5, false, false),
  (11, 5, false, false),
  (12, 5, false, false);


INSERT INTO loan (book_copy_id, loan_date, expected_return_date, return_date, user_id, returned) VALUES (1, '2022-05-10', '2022-06-10', null, 1, false);
INSERT INTO loan (book_copy_id, loan_date, expected_return_date, return_date, user_id, returned) VALUES (2, '2022-05-09', '2022-06-09', null, 2, false);
INSERT INTO loan (book_copy_id, loan_date, expected_return_date, return_date, user_id, returned) VALUES (3, '2022-05-08', '2022-06-08', null, 3, false);
INSERT INTO loan (book_copy_id, loan_date, expected_return_date, return_date, user_id, returned) VALUES (4, '2022-05-07', '2022-06-07', null, 4, true);
INSERT INTO loan (book_copy_id, loan_date, expected_return_date, return_date, user_id, returned) VALUES (5, '2022-05-06', '2022-06-06', null, 5, true);
