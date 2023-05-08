-- Users
INSERT INTO public.users (id, first_name, last_name, gender, age, department_id)
VALUES (1, 'Deloris', 'Caistor', 'FEMALE', 1, '643d1a48362ea1a74ec9f49d');
INSERT INTO public.users (id, first_name, last_name, gender, age, department_id)
VALUES (2, 'Colas', 'Parrott', 'MALE', 2, '643d1a48362ea1a74ec9f4a2');
INSERT INTO public.users (id, first_name, last_name, gender, age, department_id)
VALUES (3, 'Travus', 'Dominy', 'MALE', 3, '643d1a48362ea1a74ec9f4a5');
INSERT INTO public.users (id, first_name, last_name, gender, age, department_id)
VALUES (4, 'Theresina', 'Kordova', 'FEMALE', 4, '643d1a48362ea1a74ec9f4a2');
INSERT INTO public.users (id, first_name, last_name, gender, age, department_id)
VALUES (5, 'Veda', 'Grieves', 'FEMALE', 5, '643d1a48362ea1a74ec9f4a4');
INSERT INTO public.users (id, first_name, last_name, gender, age, department_id)
VALUES (6, 'Cleopatra', 'Dodworth', 'FEMALE', 6, '643d1a48362ea1a74ec9f4a1');
INSERT INTO public.users (id, first_name, last_name, gender, age, department_id)
VALUES (7, 'Demetria', 'Habbin', 'FEMALE', 7, '643d1a48362ea1a74ec9f49f');
INSERT INTO public.users (id, first_name, last_name, gender, age, department_id)
VALUES (8, 'Tracie', 'Peddowe', 'MALE', 8, '643d1a48362ea1a74ec9f49d');
INSERT INTO public.users (id, first_name, last_name, gender, age, department_id)
VALUES (9, 'Chaddy', 'Vooght', 'MALE', 9, '643d1a48362ea1a74ec9f4a4');
INSERT INTO public.users (id, first_name, last_name, gender, age, department_id)
VALUES (10, 'Dane', 'Treasaden', 'MALE', 10, '643d1a48362ea1a74ec9f49f');

SELECT setval('users_id_seq', (SELECT max(id) from users), true);


-- Accounts
INSERT INTO public.accounts (id, user_id, balance) VALUES (1, 1, 13);
INSERT INTO public.accounts (id, user_id, balance) VALUES (2, 2, 77);
INSERT INTO public.accounts (id, user_id, balance) VALUES (3, 3, 26);
INSERT INTO public.accounts (id, user_id, balance) VALUES (4, 4, 94);
INSERT INTO public.accounts (id, user_id, balance) VALUES (5, 5, 21);
INSERT INTO public.accounts (id, user_id, balance) VALUES (6, 6, 99);
INSERT INTO public.accounts (id, user_id, balance) VALUES (7, 7, 46);
INSERT INTO public.accounts (id, user_id, balance) VALUES (8, 8, 52);
INSERT INTO public.accounts (id, user_id, balance) VALUES (9, 9, 50);
INSERT INTO public.accounts (id, user_id, balance) VALUES (10, 10, 69);

SELECT setval('accounts_id_seq', (SELECT max(id) from accounts), true);


-- Emails
INSERT INTO public.emails (id, user_id, email) VALUES (1, 1, 'fcosbey0@cdc.gov');
INSERT INTO public.emails (id, user_id, email) VALUES (2, 2, 'dgaddes1@theglobeandmail.com');
INSERT INTO public.emails (id, user_id, email) VALUES (3, 3, 'mbradmore2@slideshare.net');
INSERT INTO public.emails (id, user_id, email) VALUES (4, 4, 'gmaystone3@slashdot.org');
INSERT INTO public.emails (id, user_id, email) VALUES (5, 5, 'dervine4@privacy.gov.au');
INSERT INTO public.emails (id, user_id, email) VALUES (6, 6, 'jdohrmann5@buzzfeed.com');
INSERT INTO public.emails (id, user_id, email) VALUES (7, 7, 'mdockrill6@ed.gov');
INSERT INTO public.emails (id, user_id, email) VALUES (8, 8, 'rroistone7@usda.gov');
INSERT INTO public.emails (id, user_id, email) VALUES (9, 9, 'nslipper8@trellian.com');
INSERT INTO public.emails (id, user_id, email) VALUES (10, 10, 'showsan9@mlb.com');

SELECT setval('emails_id_seq', (SELECT max(id) from emails), true);

-- Phones
INSERT INTO public.phones (id, user_id, phone) VALUES (1, 1, '+48 (213) 938-5247');
INSERT INTO public.phones (id, user_id, phone) VALUES (2, 2, '+63 (853) 133-2737');
INSERT INTO public.phones (id, user_id, phone) VALUES (3, 3, '+52 (689) 684-6381');
INSERT INTO public.phones (id, user_id, phone) VALUES (4, 4, '+55 (368) 905-3620');
INSERT INTO public.phones (id, user_id, phone) VALUES (5, 5, '+420 (669) 590-0388');
INSERT INTO public.phones (id, user_id, phone) VALUES (6, 6, '+1 (210) 191-6664');
INSERT INTO public.phones (id, user_id, phone) VALUES (7, 7, '+55 (942) 307-6011');
INSERT INTO public.phones (id, user_id, phone) VALUES (8, 8, '+504 (322) 756-6265');
INSERT INTO public.phones (id, user_id, phone) VALUES (9, 9, '+1 (407) 403-9816');
INSERT INTO public.phones (id, user_id, phone) VALUES (10, 10, '+62 (833) 254-0600');

SELECT setval('phones_id_seq', (SELECT max(id) from phones), true);




