package game;

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
			// Insert records
			
			// Create items
			Weapons sword = WeaponsDao.create(cxn,"Sword of Valor",10,1,1500.00,10,"Warrior",50);
			int swordID = sword.getItemID();
			Equipments swordEquip = EquipmentsDao.getEquipmentByItemID(cxn, swordID);
			Gears helmet = GearsDao.create(cxn,"Iron Helmet",1,1,200.00,5);
			
			// Create stats
			Statistics strength = StatisticsDao.create(cxn, "Strength", null);
			
			// Create bonuse
			EquipmentBonuse swordStrength = EquipmentBonuseDao.create(cxn, swordEquip, strength, 5);
			
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
					ON DELETE RESTRICT);
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
				    on delete restrict);
							""");
		}
	}
}
