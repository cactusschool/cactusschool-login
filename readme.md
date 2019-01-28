1. Install java jdk 1.8
2. Install heidisql 
		Windows: https://www.heidisql.com/download.php
		ubuntu: sudo apt-get install wine
					Download installer from https://www.heidisql.com/download.php
					GO to the downloaded path: then execute "wine <downloaded file name>.exe"
					
					
					
					
CREATE TABLE `school_master` (
	`school_id` INT(11) NOT NULL,
	`school_parent_id` INT(11) NOT NULL,
	`school_group_name` VARCHAR(150) NULL DEFAULT NULL,
	`school_name` VARCHAR(150) NOT NULL,
	`address_id` INT(11) NOT NULL COMMENT 'Physical address and phone number',
	`context_root` VARCHAR(50) NOT NULL,
	`db_name` VARCHAR(50) NOT NULL,
	`school_code` VARCHAR(50) NOT NULL,
	`sms_sender_id` VARCHAR(50) NOT NULL,
	`contract_id` INT(11) NOT NULL COMMENT 'Contract Details',
	`delete_ind` VARCHAR(2) NOT NULL,
	`delete_reason` VARCHAR(100) NOT NULL,
	`create_user` VARCHAR(100) NOT NULL,
	`create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`update_user` VARCHAR(100) NOT NULL,
	`update_date` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00'
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

CREATE TABLE `address` (
	`address_id` INT(11) NOT NULL AUTO_INCREMENT,
	`address_name` VARCHAR(100) NOT NULL,
	`address_line1` VARCHAR(75) NOT NULL,
	`address_line2` VARCHAR(75) NULL DEFAULT NULL,
	`address_line3` VARCHAR(75) NULL DEFAULT NULL,
	`city` VARCHAR(100) NULL DEFAULT NULL,
	`pin_code` VARCHAR(10) NULL DEFAULT NULL,
	`dist_code` VARCHAR(4) NULL DEFAULT NULL,
	`state_code` VARCHAR(4) NULL DEFAULT NULL,
	`country_code` VARCHAR(4) NULL DEFAULT NULL,
	`delete_ind` VARCHAR(2) NULL DEFAULT NULL,
	`delete_reason` VARCHAR(100) NULL DEFAULT NULL,
	`create_user` VARCHAR(100) NULL DEFAULT NULL,
	`create_date` TIMESTAMP NULL DEFAULT NULL,
	`update_user` VARCHAR(100) NULL DEFAULT NULL,
	`update_date` TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (`address_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
