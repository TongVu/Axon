INSERT INTO ebook(id,
				page,
				title
				rating
				introduction
				purchased,
				view_link_status)
VALUES  	(10001, 420 , 'Cloud Cuckoo Land',                            2, 'An allusive Greek text casts a spell across millennia, capturing a glittering array of characters—from a teenager in 1453 Constantinople to an eco-terrorist in present day Idaho—in this opulent marvel of a novel by the Pulitzer-winning author of All the Light We Cannot See.', false, 'somelink'),
            (10002, 420 , 'Kane and Abel',                              4.5, 'Kane and Abel is a 1979 novel by British author Jeffrey Archer. Released in the United Kingdom in 1979 and in the United States in February 1980, the book was an international success, selling over one million copies in its first week. It reached No. 1 on the New York Times best-seller list.', true, 'somelink'),
            (10003, 400 , 'Norwegian Wood',                             4.5, 'Norwegian Wood is a 1987 novel by Japanese author Haruki Murakami. The novel is a nostalgic story of loss and burgeoning sexuality. It is told from the first-person perspective of Toru Watanabe, who looks back on his days as a college student living in Tokyo.', true, 'somelink'),
            (10004, 505 , 'Kafka on the Shore',                         4.1, 'Kafka on the Shore is a 2002 novel by Japanese author Haruki Murakami. Its 2005 English translation was among The 10 Best Books of 2005 from The New York Times and received the World Fantasy Award for ,2006', true, 'somelink'),
            (10005, 607 , 'The Wind-Up Bird Chronicle',                 4.2, 'The Wind-Up Bird Chronicle is a novel published in 1994–1995 by Japanese author Haruki Murakami. The American translation and its British adaptation, dubbed the only official translations, are by Jay Rubin and were first published in 1997.', false, 'somelink'),
            (10006, 1484, '1Q84',                                       4.9, '1Q84 is a novel written by Japanese writer Haruki Murakami, first published in three volumes in Japan in 2009–10. It covers a fictionalized year of 1984 in parallel with a real one. The novel is a story of how a woman named Aomame begins to notice strange changes occurring in the world.', true, 'somelink'),
            (10007, 349 , 'Stiff: The Curious Lives of Human Cadavers', 4.0, 'Stiff: The Curious Lives of Human Cadavers is a 2003 nonfiction book by Mary Roach. Published by W. W. Norton & Company, it details the unique scientific contributions of the deceased.', false, 'somelink'),
            (10008, 390 , 'Educated',                                   4.5, 'Educated is a memoir by the American author Tara Westover. Westover recounts overcoming her survivalist Mormon family in order to go to college, and emphasizes the importance of education in enlarging her world.', false, 'somelink'),
            (10009, 555 , 'English Grammar in Use',                     4.5, 'English Grammar in Use is a self-study reference and practice book for intermediate to advanced students of English. The book was written by Raymond Murphy and published by Cambridge University Press.', false, 'somelink'),
            (10010, 210 , 'The Diaries of Adam and Eve',                4.7, 'Diaries of Adam and Eve', 'is a short text that tells two parallel stories, but from different points of view. These stories are, of course, the life of Adam since the Creator sent his mate to him, and the life of Eve since she appeared in the Garden of Eden', true, 'somelink')
	
	
	
	
INSERT INTO publisher(name,
					phone,
					address,
					email)
VALUES      ('Stairway Press',0933258257,'Phoenix, US','stairwaypress@gmail.com'),
            ('Dundurn Press',0943268257,'Toronto, CA','dundrunpress@gmail.com'),
            ('Knopf Doubleday',0968258250,'New York City, US','knopfdoubleday@gmail.com'),
            ('Crown Publishing',0930250250,'New York City, US','crownpublishing@gmail.com'),
            ('Autumn House Press',0900058257,'Philadelphia, US','autumnhousepress@gmail.com'),
            ('Algonquin Books',0933288227,'Raleigh, US','algonquinbooks@gmail.com'),
            ('Dover Publications',0932258257,'New York City, US','doverpublications@gmail.com'),
            ('Drawn and Quarterly',0979258257,'Toronto, CA','drawnandquarterly@gmail.com'),
            ('Coffee House Press',0933258000,'Minneapolis, US','coffeehousepress@gmail.com')
		
		
		
		
INSERT INTO author(
            dob,
            address,
            gender,
            first_name,
            last_name,
            email,
            phone,
            nationality)
    VALUES 	( '1972-10-27', 'American'     , 0, 'Anthony', 'Doerr'   , 'anthonydoerr@gmail.com' , 0909236237, 'American'),
			( '1939-04-15', 'London'       , 0, 'Jeffrey', 'Archer'  , 'jeffreyarcher@gmail.com', 0909274942, 'English'),
			( '1948-01-12', 'Tokyo'        , 0, 'Haruki' , 'Murakami', 'hiramurakami@gmail.com' , 0909777250, 'Japanese'),
			( '1958-03-20', 'New Hampshire', 1, 'Mary'   , 'Roach'   , 'maryroach@gmail.com'    , 0909555537, 'American'),
			( '1972-10-27', 'Idaho'        , 1, 'Tara'   , 'Westover', 'tarawestover@gmail.com' , 0918394729, 'American'),
			( '1926-12-13', 'Michigan'     , 0, 'Raymond', 'Murphy'  , 'raymondmurphy@gmail.com', 0943218590, 'American'),
			( '1834-11-30', 'Missouri'     , 0, 'Mark'   , 'Twain'   , 'marktwain@gmail.com'    , 0909923626, 'American')
