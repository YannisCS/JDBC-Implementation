package game;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
	
	@SuppressWarnings("unused")
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
			Players P6 = PlayersDao.create(cxn, "Ethan", "Potter", "ethan@example.com");
			
			//Insert Clans
			Clans clan1 = ClansDao.create(cxn, "Lionhearts", Clans.Races.HUMAN);
			Clans clan2 = ClansDao.create(cxn, "ElvenGuardians", Clans.Races.ELF);
			Clans clan3 = ClansDao.create(cxn, "MountainHammers", Clans.Races.DWARF);
			Clans clan4 = ClansDao.create(cxn, "BloodFury", Clans.Races.ORC);
			Clans clan5 = ClansDao.create(cxn, "ShadowStalkers", Clans.Races.GOBLIN);
			Clans clan6 = ClansDao.create(cxn, "StarFall", Clans.Races.ELF);
			
			//Insert Items: 15 items: 5 Weapons, 5 Gears, and 5 Consumables.
			/*Insert Weapons*/
			//Weapons sword = WeaponsDao.create(cxn,"Sword of Valor",10,1,1500.00,10,"Warrior",50);
			Weapons sword = WeaponsDao.create(cxn,"Sword of Valor",10,1,BigDecimal.valueOf(1500.00),10,"Warrior",50);
			Weapons axe = WeaponsDao.create(cxn,"Axe of Fury",12,1,BigDecimal.valueOf(1700.00),12,"Mage", 45);
			Weapons spear = WeaponsDao.create(cxn,"Spear of Destiny",11,1,BigDecimal.valueOf(1600.00),11,"Archer",40);
			Weapons bow = WeaponsDao.create(cxn,"Bow of Eternity",9,1,BigDecimal.valueOf(1400.00),9,"Thief",35);
			Weapons dagger = WeaponsDao.create(cxn,"Dagger of Stealth",8,1,BigDecimal.valueOf(1300.00),8,"Healer",30);

			/*Insert Gears*/
			Gears helmet = GearsDao.create(cxn,"Iron Helmet",1,1,BigDecimal.valueOf(200.00),5);
			Gears armor = GearsDao.create(cxn,"Steel Armor",10,1,BigDecimal.valueOf(2000.00),10);
			Gears boots = GearsDao.create(cxn,"Leather Boots",4,1,BigDecimal.valueOf(450.00),4);
			Gears boots1 = GearsDao.create(cxn,"Leather Boots",4,5,BigDecimal.valueOf(550.00),3);

			Gears gloves = GearsDao.create(cxn,"Chainmail Gloves",6,1,BigDecimal.valueOf(600.00),6);
			Gears legging = GearsDao.create(cxn,"Plate Leggings",7,1,BigDecimal.valueOf(800.00),7);
			
			/*Insert Consumables*/
			Consumables smallHealthPotion = ConsumablesDao.create(cxn, "Small Health Potion", 1, 20, new BigDecimal("50.00"), "Restores 50 HP.");
			Consumables largeHealthPotion = ConsumablesDao.create(cxn, "Large Health Potion", 1, 20, new BigDecimal("75.00"), "Restores 100 HP.");
			Consumables manaPotion = ConsumablesDao.create(cxn, "Mana Potion", 1, 20, new BigDecimal("65.00"), "Restores 30 MP.");
			Consumables staminaPotion = ConsumablesDao.create(cxn, "Stamina Potion", 1, 20, new BigDecimal("55.00"), "Boosts stamina temporarily.");
			Consumables antidote = ConsumablesDao.create(cxn, "Antidote", 1, 15, new BigDecimal("40.00"), "Cures poison.");
			
			//Insert Statistics
			Statistics strength = StatisticsDao.create(cxn, "Strength", "Determines physical power.");
			Statistics agility = StatisticsDao.create(cxn, "Agility", "Determines speed and dexterity.");
			Statistics intelligence = StatisticsDao.create(cxn, "Intelligence", "Determines magical ability.");
			Statistics endurance = StatisticsDao.create(cxn, "Endurance", "Determines stamina and resilience.");
			Statistics luck = StatisticsDao.create(cxn, "Luck", "Determines chance of critical hits.");			
			
			//Insert Currencies
			Currencies gold = CurrenciesDao.create(cxn, "Gold", new BigDecimal(1000.00), null);
			Currencies silver = CurrenciesDao.create(cxn, "Silver", null, new BigDecimal("100.00"));
			Currencies bronze = CurrenciesDao.create(cxn, "Bronze", null, null);
			Currencies platinum = CurrenciesDao.create(cxn, "Platinum",new BigDecimal(300.00), new BigDecimal(30.00));
			Currencies diamond = CurrenciesDao.create(cxn, "Diamond", new BigDecimal(50.00), new BigDecimal(5.00));
			
			//Insert Characters
			Characters Char1 = CharactersDao.create(cxn, P1, "Alicia", "Storm", clan1, sword);
			Characters Char2 = CharactersDao.create(cxn, P2, "Boris", "Flame", clan2, axe);
			Characters Char3 = CharactersDao.create(cxn, P3, "Cecilia", "Wind", clan3, spear);
			Characters Char4 = CharactersDao.create(cxn, P4, "Derek", "Stone", clan4, bow);
			Characters Char5 = CharactersDao.create(cxn, P5, "Eva", "Night", clan5, dagger);
			
		    //Insert CharacterStatistics
			CharacterStatistics charStat1 = CharacterStatisticsDao.create(cxn, Char1, strength, 10);
			CharacterStatistics charStat2 = CharacterStatisticsDao.create(cxn, Char2, agility, 12);
			CharacterStatistics charStat3 = CharacterStatisticsDao.create(cxn, Char3, intelligence, 15);
			CharacterStatistics charStat4 = CharacterStatisticsDao.create(cxn, Char4, endurance, 11);
			CharacterStatistics charStat5 = CharacterStatisticsDao.create(cxn, Char5, luck, 8);
				
			//Insert EquipmentBonuse
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, sword.getItemID()), strength, 5);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, boots.getItemID()), agility, 3);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, spear.getItemID()), intelligence, 4);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, helmet.getItemID()), endurance, 11);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, axe.getItemID()), strength, 10);

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
			CharacterUnlockedJob CUJ1 = CharacterUnlockedJobDao.create(cxn, Char1, "Warrior", 1, 100);
			CharacterUnlockedJob CUJ2 = CharacterUnlockedJobDao.create(cxn, Char1, "Mage", null, null);
			CharacterUnlockedJob CUJ3 = CharacterUnlockedJobDao.create(cxn, Char2, "Mage", 2, 200);
			CharacterUnlockedJob CUJ4 = CharacterUnlockedJobDao.create(cxn, Char3, "Archer", 3, 300);
			CharacterUnlockedJob CUJ5 = CharacterUnlockedJobDao.create(cxn, Char4, "Thief", 4, 400);
			CharacterUnlockedJob CUJ6 = CharacterUnlockedJobDao.create(cxn, Char5, "Healer", 5, 500);
			
			//Insert CharacterWealth
			CharacterWealth CW1 = CharacterWealthDao.create(cxn, Char1, gold, new BigDecimal(500.00), new BigDecimal(50.00));
			CharacterWealth CW2 = CharacterWealthDao.create(cxn, Char2, silver, new BigDecimal(1000.00), new BigDecimal(100.00));
			CharacterWealth CW3 = CharacterWealthDao.create(cxn, Char3, bronze, new BigDecimal(300.00), new BigDecimal(30.00));
			CharacterWealth CW4 = CharacterWealthDao.create(cxn, Char4, platinum, new BigDecimal(150.00), new BigDecimal(15.00));
			CharacterWealth CW5 = CharacterWealthDao.create(cxn, Char5, diamond, new BigDecimal(20.00), null);

			
			
			//Insert Inventory
			Inventory inven1 = InventoryDao.create(cxn, Char1, 1, armor, 1);
			Inventory inven2 = InventoryDao.create(cxn, Char2, 2, boots, 1);
			Inventory inven3 = InventoryDao.create(cxn, Char3, 3, spear, 1);
			Inventory inven4 = InventoryDao.create(cxn, Char4, 4, gloves, 1);
			Inventory inven5 = InventoryDao.create(cxn, Char5, 5, helmet, 1);


			//Insert EquippedItems
			EquippedItems equippedItem1 = EquippedItemsDao.create(cxn, Char1, "HEAD", helmet);
			EquippedItems equippedItem2 = EquippedItemsDao.create(cxn, Char2, "BODY", armor);
			EquippedItems equippedItem3 = EquippedItemsDao.create(cxn, Char3, "FOOT", boots);
			EquippedItems equippedItem4 = EquippedItemsDao.create(cxn, Char4, "HAND", gloves);
			EquippedItems equippedItem5 = EquippedItemsDao.create(cxn, Char5, "LEG", legging);
			
			/**
			 * Read records
			 */		
			System.out.println("-------Testing Read Records Operations-------");
			//Read Players
			Players player1Test = PlayersDao.getPlayerByPlayerID(cxn, P1.getPlayerID());
		    System.out.format("* Reading Players\nReading Single Players: PlayerId:%s FirstName:%s LastName:%s Email:%s \n",
		      player1Test.getPlayerID(), player1Test.getFirstName(), player1Test.getLastName(), player1Test.getEmailAddress());
			
		    //Read a list of Players
		    System.out.format("Reading a list of Players:");
		    List<Players> playersList = PlayersDao.getPlayersFromFirstName(cxn, "Ethan");
		    for (Players player : playersList) {
		        System.out.format("\n	Looping Players: PlayerId:%s FirstName:%s LastName:%s Email:%s",
		        		player.getPlayerID(), player.getFirstName(), player.getLastName(), player.getEmailAddress());
		      }
			
		    System.out.println();
			//Read Clans
		    System.out.println("\n* Reading Clans");
		    /* get clan and its race by a specific clanName */
		    Clans clanrace = ClansDao.getClanRacebyClanName(cxn, "Lionhearts");
		    System.out.format("get Clans record by clanName=%s:%n	%s", "Lionhearts", clanrace.toString());
		    
		    /* get a list of clans for a specific race */
		    List<Clans> clans = ClansDao.getClansbyRace(cxn, Clans.Races.ELF);
		    System.out.print("\n\nget a list of clans by Race = elf:");
		    for (Clans c : clans) {
		    	System.out.format("%n	clan=%s | race=%s", c.getClanName(), c.getRace());
		    }
			
			//Read Items			
			//Read Equipments
		    System.out.println();
		    Equipments equip1 = EquipmentsDao.getEquipmentByItemID(cxn, sword.getItemID());
		    System.out.println("\n* Reading equipment: \n" + equip1.toString());
			
			//Read Gears
		    Gears gear1 = GearsDao.getGearByItemID(cxn,helmet.getItemID());
		    System.out.println("\n* Reading gear: \n" + gear1.toString());
			
			//Read Weapons
		    Weapons weapon1 = WeaponsDao.getWeaponByItemID(cxn, sword.getItemID());
		    System.out.println("\n* Reading weapon:\n" + weapon1.toString());
			
			//Read Characters
		    Characters char1Test = CharactersDao.getCharacterByCharID(cxn, Char1.getCharID());
		    System.out.format("\n* Reading Characters: charID:%s playerID:%s firstName:%s lastName:%s clan:%s weaponWeared:%s \n",
		      char1Test.getCharID(), char1Test.getPlayers().getPlayerID(), char1Test.getFirstName(), char1Test.getLastName(), char1Test.getClan(), char1Test.getWeaponWeared());
			
			//Read Statistics
		    Statistics readStatTest = StatisticsDao.getStatisticsByName(cxn, "Strength");
		    System.out.println("\n* Reading statistics of strength: " + readStatTest.toString());
			
			//Read Currencies
		    Currencies readCurrencyTest = CurrenciesDao.getCurrenciesByName(cxn, "Gold");
		    System.out.println("\n* Reading currency: Gold, " + readCurrencyTest.toString());
			
			//Read CharacterStatistics
		    CharacterStatistics readCharStat1 = CharacterStatisticsDao.getCharacterStatByCharacterAndStat(cxn, Char1, strength);
		    System.out.println("\n* Reading strength value of char1: " + readCharStat1.toString());
			
			//Read EquipmentBonuse
		    EquipmentBonuse  swordStrength = EquipmentBonuseDao.getEquipmengBonuseByEquipmentAndStats(cxn, sword, strength);
		    System.out.println("\n* Reading strength of sword: \n" + swordStrength.toString());
			
			//Read Consumables
		    Consumables cons = ConsumablesDao.getConsumableByItemID(cxn, 13);
		    System.out.format("\n\n* Reading consumable item with itemID=13: \n%s", cons.toString());
			
			//Read ConsumableItemBonuse
		    ConsumableItemBonuse consBonuse = ConsumableItemBonuseDao.getBonuseByItemAndStatistics(cxn, largeHealthPotion.getItemID(), "intelligence");
		    System.out.format("\n\n* Reading strength for Consumable item with itemID=13:\nbonusePercent=%f | valueCap=%d", consBonuse.getBonusePercent(), consBonuse.getValueCap());
			
			//Read JobsForGear
		    JobsForGear jfg1Test = JobsForGearDao.getJobsForGearByID(cxn, helmet, "Warrior");
		    System.out.format("\n\n* Reading JobsForGear: gear:%s jobName:%s", jfg1Test.getGear().getItemID(), jfg1Test.getJob());
			
			//Read CharacterUnlockedJob
		    CharacterUnlockedJob cuj1Test = CharacterUnlockedJobDao.getCharacterUnlockedJobByID(cxn, Char1.getCharID(), "Warrior");
		    System.out.format("\n\n* Reading CharacterUnlockedJob: charID:%s jobName:%s jobLevel:%s XP:%s", 
		    		          cuj1Test.getCharacter().getCharID(), cuj1Test.getJob(), cuj1Test.getJobLevel(), cuj1Test.getxP());
			
			//Read CharacterWealth
		    CharacterWealth readCharWealth = CharacterWealthDao.getCharacterWealthByCharacterAndCurrency(cxn, Char1, gold);
		    System.out.println("\n\n* Reading character1 gold stats: " + readCharWealth.toString());
			
			//Read Inventory
		    System.out.println("\n* Reading Inventories");
		    Inventory inv1 = InventoryDao.getInventoryByCharactersAndSlot(cxn, Char1, 1);
		    System.out.format("Reading Inventory1: charID:%s slotID:%s itemID:%s quantity:%s", inv1.getCharID(), inv1.getSlotID(),inv1.getInstance(),inv1.getQuantity());

		    Inventory inv2 = InventoryDao.getInventoryByCharactersAndSlot(cxn, Char2, 2);
		    System.out.format("\nReading Inventory2: charID:%s slotID:%s itemID:%s quantity:%s", inv2.getCharID(), inv2.getSlotID(),inv2.getInstance(),inv2.getQuantity());

		    Inventory inv3 = InventoryDao.getInventoryByCharactersAndSlot(cxn, Char3, 3);
		    System.out.format("\nReading Inventory3: charID:%s slotID:%s itemID:%s quantity:%s", inv3.getCharID(), inv3.getSlotID(),inv3.getInstance(),inv3.getQuantity());

		    Inventory inv4 = InventoryDao.getInventoryByCharactersAndSlot(cxn, Char4, 4);
		    System.out.format("\nReading Inventory4: charID:%s slotID:%s itemID:%s quantity:%s", inv4.getCharID(), inv4.getSlotID(),inv4.getInstance(),inv4.getQuantity());

		    Inventory inv5 = InventoryDao.getInventoryByCharactersAndSlot(cxn, Char5, 5);
		    System.out.format("\nReading Inventory5: charID:%s slotID:%s itemID:%s quantity:%s", inv5.getCharID(), inv5.getSlotID(),inv5.getInstance(),inv5.getQuantity());

		    
			//Read EquippedItems
		    System.out.println("\n * Reading EquippedItems");
			EquippedItems equipedIte1 = EquippedItemsDao.getEquippedItemsByCharIDAndSlot(cxn, Char1.getCharID(), "HEAD");
		    System.out.format("\nReading EquippedItems1: charID:%s equipPosition:%s itemID:%s ", equipedIte1.getCharID(), equipedIte1.getEquipPosition(),equipedIte1.getItemID());

			EquippedItems equipedIte2 = EquippedItemsDao.getEquippedItemsByCharIDAndSlot(cxn, Char2.getCharID(), "BODY");
		    System.out.format("\nReading EquippedItems2: charID:%s equipPosition:%s itemID:%s \n", equipedIte2.getCharID(), equipedIte2.getEquipPosition(),equipedIte2.getItemID());
		    System.out.println();

			/**
			 * Update records
			 */		
			System.out.println("-------Testing Update Records Operations-------");
		    //Update Players firstName
		    System.out.println("* Updating Players firstName: ");
		    System.out.println("Before updating: ");
		    System.out.format("Reading Players: PlayerId:%s FirstName:%s LastName:%s Email:%s \n",
		      P1.getPlayerID(), P1.getFirstName(), P1.getLastName(), P1.getEmailAddress());
		    PlayersDao.updatePlayerFirstName(cxn, P1, "Harry");
		    P1 = PlayersDao.getPlayerByPlayerID(cxn, P1.getPlayerID());
		    System.out.println("After updating: ");
		    System.out.format("Reading Players: PlayerId:%s FirstName:%s LastName:%s Email:%s \n",
		      P1.getPlayerID(), P1.getFirstName(), P1.getLastName(), P1.getEmailAddress());
		    
		    //Update Players lastName
		    System.out.println("* Updating Players lastName: ");
		    System.out.println("Before updating: ");
		    System.out.format("Reading Players: PlayerId:%s FirstName:%s LastName:%s Email:%s \n",
		      P1.getPlayerID(), P1.getFirstName(), P1.getLastName(), P1.getEmailAddress());
		    PlayersDao.updatePlayerLastName(cxn, P1, "Potter");
		    P1 = PlayersDao.getPlayerByPlayerID(cxn, P1.getPlayerID());
		    System.out.println("After updating: ");
		    System.out.format("Reading Players: PlayerId:%s FirstName:%s LastName:%s Email:%s \n",
		      P1.getPlayerID(), P1.getFirstName(), P1.getLastName(), P1.getEmailAddress());
		   
		    //Update Players emailAddress
		    System.out.println("* Updating Players emailAddress: ");
		    System.out.println("Before updating: ");
		    System.out.format("Reading Players: PlayerId:%s FirstName:%s LastName:%s Email:%s \n",
		      P1.getPlayerID(), P1.getFirstName(), P1.getLastName(), P1.getEmailAddress());
		    PlayersDao.updatePlayerEmailAddress(cxn, P1, "harry@example.com");
		    P1 = PlayersDao.getPlayerByPlayerID(cxn, P1.getPlayerID());
		    System.out.println("After updating: ");
		    System.out.format("Reading Players: PlayerId:%s FirstName:%s LastName:%s Email:%s \n",
		      P1.getPlayerID(), P1.getFirstName(), P1.getLastName(), P1.getEmailAddress());
		   
		    
		    //Update Clans clanName
		    System.out.format(
		    		"%n* Updating Clans clanName %nBefore updating: %s", 
		    		clan6.toString()
		    		);
		    clan6 = ClansDao.updateClanName(cxn, clan6, "StarWars");
		    System.out.format(
		    		"%nAfter updating: %s", 
		    		clan6.toString()
		    		);
		    
		    //Update Consumables description
		    System.out.format(
		    		"%n%n* Updating Consumables description %nBefore updating: %s", 
		    		antidote.toString()
		    		);
		    int antidoteItemID = antidote.getItemID();
		    ConsumablesDao.updateConsumablesDescription(cxn, antidote, "A potion that cures poison effects, restoring the user’s health and vitality.");
		    antidote = ConsumablesDao.getConsumableByItemID(cxn, antidoteItemID);
		    System.out.format(
		    		"%nAfter updating: %s", 
		    		antidote.toString()
		    		);
		    
		    
			//Update EquippedItems itemID
		    System.out.format(
		    		"%n%n* Updating EquippedItems gear %nBefore updating: %s", 
		    		equippedItem3.toString()
		    		);
		    
			EquippedItemsDao.updateEquippedItems(cxn, equippedItem3, boots1);
		    System.out.format(
		    		"%nAfter updating: %s", 
		    		equippedItem3.toString()
		    		);
		    
			//Update Inventory quantity
		    System.out.format(
		    		"%n%n* Updating Inventory quantity %nBefore updating: %s", 
		    		inv1.toString()
		    		);
//		    Inventory inv1 = InventoryDao.getInventoryByCharactersAndSlot(cxn, Char1, 1);

		    InventoryDao.updateInventoryQuantity(cxn,inv1,5);
		    System.out.format(
		    		"%nAfter updating: %s", 
		    		inv1.toString()
		    		);
			System.out.println();
			System.out.println();
			
			// Update currencies
			System.out.println("* Updating currency cap");
			System.out.println("Before update: " + gold.toString());
			CurrenciesDao.updateCap(cxn, gold, new BigDecimal(2000.00));
			gold = CurrenciesDao.getCurrenciesByName(cxn, "Gold");
			System.out.println("After update: " + gold.toString());
			System.out.println();
			
			
		    
			/**
			 * Delete records
			 */
			System.out.println("-------Testing Delete Records Operations-------");
		    // Delete Players
		    System.out.println("* Deleting Players 'Ethan Potter': ");
		    System.out.println("Before deleting: ");
		    Players playToDelete = PlayersDao.getPlayerByPlayerID(cxn, P6.getPlayerID());
		    if (playToDelete != null) {
	    	  System.out.format("Reading Players: PlayerId:%s FirstName:%s LastName:%s Email:%s \n",
	    			  playToDelete.getPlayerID(), playToDelete.getFirstName(), playToDelete.getLastName(), playToDelete.getEmailAddress());
		    } else {
	          System.out.println("No player found \n");
		    }
		    PlayersDao.deletePlayerByPlayerID(cxn, P6.getPlayerID());
		    System.out.println("After deleting: ");
		    Players playDeleted = PlayersDao.getPlayerByPlayerID(cxn, P6.getPlayerID());
		    if (playDeleted != null) {
	    	  System.out.format("Reading Players: PlayerId:%s FirstName:%s LastName:%s Email:%s \n",
	    			  playDeleted.getPlayerID(), playDeleted.getFirstName(), playDeleted.getLastName(), playDeleted.getEmailAddress());
		    } else {
	          System.out.println("No player found \n");
		    }
		    
			
		    // delete Clans clan6
		    System.out.format("* Deleting clan6: %nBefore deleting: %s", clan6.toString());
		    String clan6Name = clan6.getClanName();  /* for check */
		    ClansDao.deleteClan(cxn, clan6);
		    	/* check */
		    if (ClansDao.getClanRacebyClanName(cxn, clan6Name) == null) {
		    	System.out.format(
		    			"%nAfter deleting: no record with clanName=%s found.", 
		    			clan6Name
		    			);
		    } else {
		    	System.out.println("%n%nError: clan6 still exists in the database.");
		    }
			System.out.println();
			
		    //delete EquippedItems 
			System.out.println("\n* Deleting equippedItems3");
		    int charID =  equippedItem3.getCharID();
		    String equipmentSlot = equippedItem3.getEquipPosition();
		    System.out.format("Before deleting:  charID:%s equipmentSlot:%s\n",charID,equipmentSlot);
		    
		    EquippedItemsDao.delete(cxn, equippedItem3);
		    EquippedItems deleteEquippedItem = EquippedItemsDao.getEquippedItemsByCharIDAndSlot(cxn, charID, equipmentSlot);
		    if (deleteEquippedItem != null) {
		    	
		          System.out.println("equippedItem3 still exists in the database \n");
				    System.out.format("Reading equippedItem3: charID:%s equipPosition:%s itemID:%s \n", equippedItem3.getCharID(), equippedItem3.getEquipPosition(),equippedItem3.getItemID());

			    } else {
		          System.out.println("equippedItem3 has been successfully deleted \n");
			    }
		    
		    
		    //delete Inventory
			System.out.println("* Deleting Inventory1: ");
		    System.out.format("Before deleting Inventory1: charID:%s slotID:%s itemID:%s quantity:%s\n", inv1.getCharID(), inv1.getSlotID(),inv1.getInstance(),inv1.getQuantity());
		    InventoryDao.delete(cxn, inven1);
			//Read Inventory
		    Inventory deletedInven = InventoryDao.getInventoryByCharactersAndSlot(cxn, Char1, 1);
		    if (deletedInven != null) {
		    	
		          System.out.println("inven1 still exists in the database \n");
				  System.out.format("Before deleting: charID:%s slotID:%s itemID:%s quantity:%s", deletedInven.getCharID(), deletedInven.getSlotID(),deletedInven.getInstance(),deletedInven.getQuantity());

			    } else {
		          System.out.println("After deleting: inven1 has been successfully deleted \n");
			    }
		}
	}

	
	public static void resetSchema() throws SQLException {
		try (Connection cxn = ConnectionManager.getConnection()) {
			cxn.createStatement().executeUpdate("DROP SCHEMA IF EXISTS CS5200Project;");
			cxn.createStatement().executeUpdate("CREATE SCHEMA CS5200Project;");
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
			/* //remove the enum table
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `Races` (
					    `raceName` VARCHAR(255),
					    CONSTRAINT pk_races PRIMARY KEY (raceName)
					);
							""");*/
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `Clans` (
					    `clanName` VARCHAR(255),
					    `race` enum('dwarf', 'elf', 'goblin', 'human', 'orc') NOT NULL,
					    CONSTRAINT pk_clans PRIMARY KEY (clanName)
					);
							""");
			/* //remove the enum tables
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
						ON DELETE CASCADE
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
					        ON DELETE CASCADE
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
					        ON DELETE RESTRICT
					);
								""");
			
			
			
		}
	}
}
