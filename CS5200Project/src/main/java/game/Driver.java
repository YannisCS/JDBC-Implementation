package game;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import game.dal.*;
import game.model.*;

public class Driver {
	
	public static void main(String[] args) {
		try {
			resetSchema();
			insertRecords();
		} catch (SQLException e) {
			System.out.print("SQL Exception: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public static void insertRecords() throws SQLException {
		try (Connection cxn = ConnectionManager.getConnection()) {
			/**
			 * Insert records
			 */			
			//Insert Players
			Players P1 = PlayersDao.create(cxn, "Alice", "Smith", "alice@example.com");
			Players P2 = PlayersDao.create(cxn, "Bob", "Johnson", "bob@example.com");
			Players P3 = PlayersDao.create(cxn, "Charlie", "Williams", "charlie@example.com");
			Players P4 = PlayersDao.create(cxn, "Diana", "Brown", "diana@example.com");
			Players P5 = PlayersDao.create(cxn, "Ethan", "Jones", "ethan@example.com");
			
			//Insert Clans
			Clans clan1 = ClansDao.create(cxn, "Lionhearts", Clans.Races.HUMAN);
			Clans clan2 = ClansDao.create(cxn, "ElvenGuardians", Clans.Races.ELF);
			Clans clan3 = ClansDao.create(cxn, "MountainHammers", Clans.Races.DWARF);
			Clans clan4 = ClansDao.create(cxn, "BloodFury", Clans.Races.ORC);
			Clans clan5 = ClansDao.create(cxn, "ShadowStalkers", Clans.Races.GOBLIN);
			
			//Insert Items: 15 items: 5 Weapons, 5 Gears, and 5 Consumables.
			/*Insert Weapons*/
			Weapons sword = WeaponsDao.create(cxn,"Sword of Valor",10,1,1500.00,10,"Warrior",50);
			Weapons axe = WeaponsDao.create(cxn,"Axe of Fury",12,1,1700.00,12,"Mage", 45);
			Weapons spear = WeaponsDao.create(cxn,"Spear of Destiny",11,1,1600.00,11,"Archer",40);
			Weapons bow = WeaponsDao.create(cxn,"Bow of Eternity",9,1,1400.00,9,"Thief",35);
			Weapons dagger = WeaponsDao.create(cxn,"Dagger of Stealth",8,1,1300.00,8,"Healer",30);
			
			/*Insert Gears*/
			Gears helmet = GearsDao.create(cxn,"Iron Helmet",1,1,200.00,5);
			Gears armor = GearsDao.create(cxn,"Steel Armor",10,1,2000.00,10);
			Gears boots = GearsDao.create(cxn,"Leather Boots",4,1,450.00,4);
			Gears gloves = GearsDao.create(cxn,"Chainmail Gloves",6,1,600.00,6);
			Gears legging = GearsDao.create(cxn,"Plate Leggings",7,1,800.00,7);
			
			/*Insert Consumables*/
			Consumables smallHealthPotion = ConsumablesDao.create(cxn, "Small Health Potion", 1, 20, new BigDecimal("50.00"), "Restores 50 HP.");
			Consumables largeHealthPotion = ConsumablesDao.create(cxn, "Large Health Potion", 1, 20, new BigDecimal("75.00"), "Restores 100 HP.");
			Consumables manaPotion = ConsumablesDao.create(cxn, "Mana Potion", 1, 20, new BigDecimal("65.00"), "Restores 30 MP.");
			Consumables staminaPotion = ConsumablesDao.create(cxn, "Stamina Potion", 1, 20, new BigDecimal("55.00"), "Boosts stamina temporarily.");
			Consumables antidote = ConsumablesDao.create(cxn, "Antidote", 1, 15, new BigDecimal("40.00"), "Cures poison.");
			
			//Insert Statistics
			Statistics strength = StatisticsDao.create(cxn, "Strength", "Determines physical power.");
			
			//Insert Currencies
			
			//Insert Characters
			Characters Char1 = CharactersDao.create(cxn, P1, "Alicia", "Storm", clan1, sword);
			Characters Char2 = CharactersDao.create(cxn, P2, "Boris", "Flame", clan2, axe);
			Characters Char3 = CharactersDao.create(cxn, P3, "Cecilia", "Wind", clan3, spear);
			Characters Char4 = CharactersDao.create(cxn, P4, "Derek", "Stone", clan4, bow);
			Characters Char5 = CharactersDao.create(cxn, P5, "Eva", "Night", clan5, dagger);
			
		    //Insert CharacterStatistics
				
			//Insert EquipmentBonuse
			EquipmentBonuse swordStrength = EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, sword.getItemID()), strength, 5);
			EquipmentBonuse bootsAgility = EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, boots.getItemID()), agility, 3);
			EquipmentBonuse spearIntelligence = EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, spear.getItemID()), intelligence, 4);
			EquipmentBonuse helmetEndurance = EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, helmet.getItemID()), endurance, 11);
			EquipmentBonuse axeStrength = EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, axe.getItemID()), strength, 10);

			//Insert ConsumableItemBonuse
			ConsumableItemBonuse sHealthPotionBonuse = ConsumableItemBonuseDao.create(cxn, smallHealthPotion, strength, 10, 15);
			ConsumableItemBonuse lHealthPotionBonuse = ConsumableItemBonuseDao.create(cxn, largeHealthPotion, intelligence, 8, 10);
			ConsumableItemBonuse manaPotionBonuse = ConsumableItemBonuseDao.create(cxn, manaPotion, endurance, 5, 8);
			ConsumableItemBonuse staminaPotionBonuse = ConsumableItemBonuseDao.create(cxn, staminaPotion, agility, 12, 18);
			ConsumableItemBonuse antidoteBonuse = ConsumableItemBonuseDao.create(cxn, antidote, luck, 20, 25);
			
			
			//Insert JobsForGear
			JobsForGear JFG1 = JobsForGearDao.create(cxn, helmet, "Warrior");
			JobsForGear JFG2 = JobsForGearDao.create(cxn, armor, "Mage");
			JobsForGear JFG3 = JobsForGearDao.create(cxn, boots, "Archer");
			JobsForGear JFG4 = JobsForGearDao.create(cxn, gloves, "Thief");
			JobsForGear JFG5 = JobsForGearDao.create(cxn, legging, "Healer");
			
			//Insert CharacterUnlockedJob
			//TODO: Update CharacterUnlockedJob create to allow for null inputs
			CharacterUnlockedJob CUJ1 = CharacterUnlockedJobDao.create(cxn, Char1, "Warrior", 1, 100);
			CharacterUnlockedJob CUJ2 = CharacterUnlockedJobDao.create(cxn, Char1, "Mage", null, null);
			CharacterUnlockedJob CUJ3 = CharacterUnlockedJobDao.create(cxn, Char2, "Mage", 2, 200);
			CharacterUnlockedJob CUJ4 = CharacterUnlockedJobDao.create(cxn, Char3, "Archer", 3, 300);
			CharacterUnlockedJob CUJ5 = CharacterUnlockedJobDao.create(cxn, Char4, "Thief", 4, 400);
			CharacterUnlockedJob CUJ6 = CharacterUnlockedJobDao.create(cxn, Char5, "Healer", 5, 500);
			
			//Insert CharacterWealth
			
			//Insert Inventory
			
			//Insert EquippedItems
			
			
			/*Read records*/
			//Read Players
			Players player1Test = PlayersDao.getPlayerByPlayerID(cxn, P1.getPlayerID());
		    System.out.format("Reading Players: PlayerId:%s FirstName:%s LastName:%s Email:%s \n",
		      player1Test.getPlayerID(), player1Test.getFirstName(), player1Test.getLastName(), player1Test.getEmailAddress());
			
			//Read Races
			
			//Read Clans
			
			//Read Items
			
			//Read Equipments
			
			//Read Gears
			
			//Read Weapons
			
			//Read Characters
		    Characters char1Test = CharactersDao.getCharacterByCharID(cxn, Char1.getCharID());
		    System.out.format("Reading Characters: charID:%s playerID:%s firstName:%s lastName:%s clan:%s weaponWeared:%s \n",
		      char1Test.getCharID(), char1Test.getPlayers().getPlayerID(), char1Test.getFirstName(), char1Test.getLastName(), char1Test.getClan(), char1Test.getWeaponWeared());
			
			//Read Statistics
			
			//Read Currencies
			
			//Read CharacterStatistics
			
			//Read EquipmentBonuse
			
			//Read Consumables
			
			//Read ConsumableItemBonuse
			
			//Read JobsForGear
		    JobsForGear jfg1Test = JobsForGearDao.getJobsForGearByID(cxn, helmet, "Warrior");
		    System.out.format("Reading JobsForGear: gear:%s jobName:%s", jfg1Test.getGear().getItemID(), jfg1Test.getJob());
			
			//Read CharacterUnlockedJob
		    CharacterUnlockedJob cuj1Test = CharacterUnlockedJobDao.getCharacterUnlockedJobByID(cxn, Char1.getCharID(), "Warrior");
		    System.out.format("Reading CharacterUnlockedJob: charID:%s jobName:%s jobLevel:%s XP:%s", 
		    		          cuj1Test.getCharacter().getCharID(), cuj1Test.getJob(), cuj1Test.getJobLevel(), cuj1Test.getxP());
			
			//Read CharacterWealth
			
			//Read Inventory
			
			//Read EquippedItems
			
			
			
			/*Update records*/
			
			
			/*Delete records*/
			
		}
	}

	
	public static void resetSchema() throws SQLException {
		try (Connection cxn = ConnectionManager.getConnection()) {
			cxn.createStatement().executeUpdate("DROP SCHEMA IF EXISTS PM3;");
			cxn.createStatement().executeUpdate("CREATE SCHEMA PM3;");
		}
		
		try (Connection cxn = ConnectionManager.getConnection()) {
			// Create tables in order
			cxn.createStatement().executeUpdate("""
				CREATE TABLE `Players` (
				    `playerID` INTEGER AUTO_INCREMENT,
				    `firstName` VARCHAR(255) NOT NULL,
				    `lastName` VARCHAR(255) NOT NULL,
				    `emailAddress` VARCHAR(255) NOT NULL,
				    CONSTRAINT pk_players PRIMARY KEY (playerID)
				);
						""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `Clans` (
					    `clanName` VARCHAR(255),
					    `race` enum('dwarf', 'elf', 'goblin', 'human', 'orc') NOT NULL,
					    CONSTRAINT pk_clans PRIMARY KEY (clanName)
					);
							""");
			/*
			cxn.createStatement().executeUpdate("""
					CREATE TABLE AvailableJobs (
						jobName VARCHAR(255),
					    CONSTRAINT pk_AvailableJobs PRIMARY KEY (jobName)
					);
							""");
							
			cxn.createStatement().executeUpdate("""
					CREATE TABLE EquipmentSlot (
					    bodyPartName VARCHAR(255) NOT NULL, 
						CONSTRAINT pk_EquipmentSlot PRIMARY KEY (bodyPartName)
					);
							""");
							*/
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `Items` (
					    `itemID` INTEGER AUTO_INCREMENT,
					    `itemName` VARCHAR(255) NOT NULL,
					    `level` INTEGER NOT NULL,
					    `maxStackSize` INTEGER NOT NULL,
					    `price` DECIMAL(10,2),
					    CONSTRAINT pk_item PRIMARY KEY (`itemID`)
					);
							""");
			
			cxn.createStatement().executeUpdate("""
				CREATE TABLE `Equipments` (
				`itemID` INTEGER NOT NULL,
				`requiredLevel` INTEGER NOT NULL,
				CONSTRAINT pk_equipment PRIMARY KEY (`itemID`),
				CONSTRAINT fk_equipment_itemID FOREIGN KEY (`itemID`)
					REFERENCES Items(`itemID`)
					ON UPDATE CASCADE
					ON DELETE CASCADE);
					""");
			
			cxn.createStatement().executeUpdate("""
				CREATE TABLE `Gears` (
				`itemID` INTEGER,
				CONSTRAINT pk_gear PRIMARY KEY (`itemID`),
				CONSTRAINT fk_gear_itemID FOREIGN KEY (`itemID`)
					REFERENCES Equipments(`itemID`)
					ON UPDATE CASCADE
					ON DELETE CASCADE);
						""");
			
			cxn.createStatement().executeUpdate("""
				CREATE TABLE `Weapons` (
					`itemID` INTEGER,
					`wearableJob` VARCHAR(255) NOT NULL,
					`damage` INTEGER NOT NULL,
					CONSTRAINT pk_weapon PRIMARY KEY (`itemID`),
					CONSTRAINT fk_weapon_itemID FOREIGN KEY (`itemID`)
						REFERENCES Equipments(`itemID`)
						ON UPDATE CASCADE
						ON DELETE CASCADE,
					CONSTRAINT fk_weapon_job FOREIGN KEY (`wearableJob`)
						REFERENCES AvailableJobs(`jobName`)
						ON UPDATE CASCADE
						ON DELETE RESTRICT
				);
						""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `Characters` (
					    `charID` INTEGER AUTO_INCREMENT,
					    `playerID` INTEGER NOT NULL,
					    `firstName` VARCHAR(255) NOT NULL,
					    `lastName` VARCHAR(255) NOT NULL,
					    `clan` VARCHAR(255) NOT NULL,
					    `weaponWeared` INTEGER NOT NULL,
					    CONSTRAINT pk_characters PRIMARY KEY (charID),
					    constraint fk_Char_playerID FOREIGN KEY (playerID)
							references  Players(playerID)
					        on update cascade
					        on delete cascade,
						constraint fk_Char_clan FOREIGN KEY (clan)
							references  Clans(clanName)
					        on update cascade
					        on delete cascade,
						constraint fk_Char_weapon FOREIGN KEY (weaponWeared)
							references  Weapons(itemID)
					        on update cascade
					        on delete restrict
					);
							""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `Statistics` (
					    `statsName` VARCHAR(255),
					    `description` TEXT NOT NULL,
					    CONSTRAINT pk_statistics PRIMARY KEY (statsNAme)
					);
							""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `Currencies` (
					    `currencyName` VARCHAR(255),
					    `cap` DECIMAL(10,2),
					    `weeklyCap` DECIMAL(10,2),
					    CONSTRAINT pk_Currencies PRIMARY KEY (`currencyName`)
					);
							""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `CharacterStatistics` (
					    `charID` INTEGER,
					    `statistics` VARCHAR(255),
					    `value` INTEGER NOT NULL,
					    constraint pk_CharStat_charID_stat PRIMARY KEY (`charID`, `statistics`),
					    constraint fk_CharStat_charID FOREIGN KEY (charID)
							references  Characters(charID)
					        on update cascade
					        on delete cascade,
						constraint fk_CharStat_stat FOREIGN KEY (statistics)
							references Statistics(statsName)
					        on update cascade
					        on delete cascade
					);
							""");
			
				
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `EquipmentBonuse` (
						`equipmentID` INTEGER NOT NULL,
						`statistics` VARCHAR(255) NOT NULL,
						`value` INTEGER NOT NULL,
						constraint pk_EquipmentBonuse PRIMARY KEY (`equipmentID`, `statistics`),
						constraint fk_EqBonuse_eqID FOREIGN KEY (equipmentID)
							references  Equipments(itemID)
						    on update cascade
						    on delete cascade,
						constraint fk_EqBonuse_stat FOREIGN KEY (statistics)
							references  Statistics(statsName)
						    on update cascade
						    on delete restrict
					);
								""");
			
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `Consumables` (
					    `itemID` INTEGER NOT NULL,
					    `description` VARCHAR(255) NOT NULL,
					    CONSTRAINT pk_consumable PRIMARY KEY (`itemID`),
					    CONSTRAINT fk_consumable_itemID FOREIGN KEY (`itemID`)
							REFERENCES Items(`itemID`)
							ON UPDATE CASCADE
							ON DELETE CASCADE
					);
								""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `ConsumableItemBonuse` (
					    `itemID` INTEGER NOT NULL,
					    `statistics` VARCHAR(255) NOT NULL,
					    `bonusePercent` FLOAT NOT NULL,
					    `valueCap` INTEGER NOT NULL,
					    constraint pk_ConsBonuse PRIMARY KEY (`itemID`, `statistics`),
					    constraint fk_ConsBonuse_itemID FOREIGN KEY (itemID)
							references  Consumables(itemID)
					        on update cascade
					        on delete cascade,
						constraint fk_ConsBonuse_stat FOREIGN KEY (statistics)
							references  Statistics(statsName)
					        on update cascade
					        on delete restrict
					);
								""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE JobsForGear (
						gear INTEGER,
					    jobName VARCHAR(255),
					    CONSTRAINT pk_JobsForGear PRIMARY KEY (gear, jobName),
					    CONSTRAINT fk_JobsForGear_gear FOREIGN KEY (gear) 
							REFERENCES Gears (itemID)
					        ON UPDATE CASCADE 
					        ON DELETE CASCADE,
						CONSTRAINT fk_JobsForGear_jobName FOREIGN KEY (jobName)
							REFERENCES AvailableJobs (jobName)
					        ON UPDATE CASCADE 
					        ON DELETE RESTRICT
					);
								""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE CharacterUnlockedJob (
						charID INTEGER,
					    jobName VARCHAR(255),
					    jobLevel INTEGER,
					    XP INTEGER,
					    CONSTRAINT pk_CharacterUnlockedJob PRIMARY KEY (charID, jobName),
						CONSTRAINT fk_CharacterUnlockedJob_charID FOREIGN KEY (charID)
							REFERENCES Characters (charID)
					        ON UPDATE CASCADE 
					        ON DELETE CASCADE,
					    CONSTRAINT fk_CharacterUnlockedJob_jobName FOREIGN KEY (jobName)
							REFERENCES AvailableJobs (jobName)
					        ON UPDATE CASCADE 
					        ON DELETE CASCADE
					);
								""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `CharacterWealth` (
					    `charID` INTEGER,
					    `currencyName` VARCHAR(255),
					    `amount` DECIMAL(10,2) NOT NULL,
					    `weeklyAcquired` DECIMAL(10,2),
					    CONSTRAINT pk_characterWealth PRIMARY KEY (`charID`, `currencyName`),
					    CONSTRAINT fk_characterWealth_currency FOREIGN KEY (`currencyName`)
					      REFERENCES `Currencies`(`currencyName`) 
					      ON UPDATE CASCADE
					      ON DELETE RESTRICT,
					    CONSTRAINT fk_characterWealth_charID FOREIGN KEY (`charID`) 
					      REFERENCES `Characters` (`charID`)
					      ON UPDATE CASCADE
					      ON DELETE CASCADE
					);
								""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE Inventory (
					    charID INT ,  
					    slotID INT ,  
					    `instance` INT NOT NULL,  
					    quantity INT NOT NULL,  
						CONSTRAINT pk_Inventory PRIMARY KEY (charID, slotID),
						CONSTRAINT fk_Inventory_Characters FOREIGN KEY (charID)
					        REFERENCES Characters(charID) 
					        ON UPDATE CASCADE 
					        ON DELETE CASCADE,
						CONSTRAINT fk_Inventory_Items FOREIGN KEY (instance)
					        REFERENCES Items(itemID) 
					        ON UPDATE CASCADE 
					        ON DELETE RESTRICT
					);
								""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE EquippedItems (
					    charID INT,  
					    equipPosition VARCHAR(255),
					    itemID INT NOT NULL,  
						CONSTRAINT pk_Inventory PRIMARY KEY (charID, equipPosition),
						CONSTRAINT fk_EquippedItems_Characters FOREIGN KEY (charID)
					        REFERENCES Characters(charID) 
					        ON UPDATE CASCADE 
					        ON DELETE CASCADE,
						CONSTRAINT fk_EquippedItems_Items FOREIGN KEY (itemID)
					        REFERENCES Gears(itemID) 
					        ON UPDATE CASCADE 
					        ON DELETE RESTRICT,
					   	CONSTRAINT fk_EquippedItems_Slot FOREIGN KEY (equipPosition)
					        REFERENCES EquipmentSlot(bodyPartName) 
					        ON UPDATE CASCADE 
					        ON DELETE RESTRICT  
					);
								""");
			
			
			
		}
	}
}
