CREATE TABLE `person` (
  `id` mediumint(8) unsigned NOT NULL,
  `name` varchar(255) default NULL,
  `age` mediumint(8) default NULL,
  `group` varchar(255),
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;