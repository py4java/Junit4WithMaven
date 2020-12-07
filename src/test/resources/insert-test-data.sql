LOCK TABLES `category` WRITE;

INSERT INTO `category` VALUES (1,'living room'),(2,'kitchen'),(3,'hall');

UNLOCK TABLES;

LOCK TABLES `product` WRITE;

INSERT INTO `product` VALUES (1,'TV','SONY ultraHD 4K','85000',3),(2,'Home theatre','Dolby Atoms','25000',3),(3,'Fridge','LG','43000',3);

UNLOCK TABLES;

