package game;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
			Players P7 = PlayersDao.create(cxn, "Ella", "Smith", "alice@example.com");
			Players P8 = PlayersDao.create(cxn, "Jane", "Johnson", "bob@example.com");
			Players P9 = PlayersDao.create(cxn, "Emma", "Wilson", "emma@example.com");
			Players P10 = PlayersDao.create(cxn, "Dan", "Brown", "dan@example.com");
			Players P11 = PlayersDao.create(cxn, "Ellen", "Jones", "ellen@example.com");
			Players P12 = PlayersDao.create(cxn, "James", "Potter", "james@example.com");
			
			//Insert Clans
			Clans clan1 = ClansDao.create(cxn, "Lionhearts", Clans.Races.HUMAN);
			Clans clan2 = ClansDao.create(cxn, "ElvenGuardians", Clans.Races.ELF);
			Clans clan3 = ClansDao.create(cxn, "MountainHammers", Clans.Races.DWARF);
			Clans clan4 = ClansDao.create(cxn, "BloodFury", Clans.Races.ORC);
			Clans clan5 = ClansDao.create(cxn, "ShadowStalkers", Clans.Races.GOBLIN);
			Clans clan6 = ClansDao.create(cxn, "StarFall", Clans.Races.ELF);
			Clans clan7 = ClansDao.create(cxn, "FrostGiants", Clans.Races.HUMAN);
			Clans clan8 = ClansDao.create(cxn, "MoonStriders", Clans.Races.ELF);
			Clans clan9 = ClansDao.create(cxn, "IronBeards", Clans.Races.DWARF);
			Clans clan10 = ClansDao.create(cxn, "RageFist", Clans.Races.ORC);
			Clans clan11 = ClansDao.create(cxn, "NightSneakers", Clans.Races.GOBLIN);
			Clans clan12 = ClansDao.create(cxn, "StoneCrusher", Clans.Races.DWARF);
			
			//Insert Items: Weapons, Gears, and Consumables.
			/*Insert Weapons*/
			Weapons sword = WeaponsDao.create(cxn,"Sword of Valor",10,1,BigDecimal.valueOf(1500.00),10,"Warrior",50);
			Weapons axe = WeaponsDao.create(cxn,"Axe of Fury",12,1,BigDecimal.valueOf(1700.00),12,"Mage", 45);
			Weapons spear = WeaponsDao.create(cxn,"Spear of Destiny",11,1,BigDecimal.valueOf(1600.00),11,"Archer",40);
			Weapons bow = WeaponsDao.create(cxn,"Bow of Eternity",9,1,BigDecimal.valueOf(1400.00),9,"Thief",35);
			Weapons dagger = WeaponsDao.create(cxn,"Dagger of Stealth",8,1,BigDecimal.valueOf(1300.00),8,"Healer",30);
			Weapons staff = WeaponsDao.create(cxn, "Staff of Wisdom", 10, 1, BigDecimal.valueOf(1550.00), 15, "Scholar", 48);
			Weapons warhammer = WeaponsDao.create(cxn, "Warhammer of Thunder", 14, 1, BigDecimal.valueOf(1850.00), 18, "Paladin", 55);
			Weapons katana = WeaponsDao.create(cxn, "Katana of Shadows", 13, 1, BigDecimal.valueOf(1750.00), 14, "Samurai", 52);
			Weapons crossbow = WeaponsDao.create(cxn, "Crossbow of Precision", 11, 1, BigDecimal.valueOf(1650.00), 12, "Hunter", 42);
			Weapons scythe = WeaponsDao.create(cxn, "Scythe of Souls", 15, 1, BigDecimal.valueOf(1900.00), 16, "Necromancer", 58);
			Weapons rapier = WeaponsDao.create(cxn, "Rapier of Swiftness", 12, 1, BigDecimal.valueOf(1600.00), 10, "Fencer", 45);
			Weapons mace = WeaponsDao.create(cxn, "Mace of Judgment", 13, 1, BigDecimal.valueOf(1700.00), 15, "Cleric", 50);

			/*Insert Gears*/
			Gears helmet = GearsDao.create(cxn,"Iron Helmet",1,1,BigDecimal.valueOf(200.00),5);
			Gears armor = GearsDao.create(cxn,"Steel Armor",10,1,BigDecimal.valueOf(2000.00),10);
			Gears boots = GearsDao.create(cxn,"Leather Boots",4,1,BigDecimal.valueOf(450.00),4);
			Gears boots1 = GearsDao.create(cxn,"Leather Boots",4,5,BigDecimal.valueOf(550.00),3);

			Gears gloves = GearsDao.create(cxn,"Chainmail Gloves",6,1,BigDecimal.valueOf(600.00),6);
			Gears legging = GearsDao.create(cxn,"Plate Leggings",7,1,BigDecimal.valueOf(800.00),7);
			
			Gears helmet2 = GearsDao.create(cxn, "Mithril Helmet", 15, 1, BigDecimal.valueOf(3000.00), 12);
			Gears chestplate = GearsDao.create(cxn, "Dragon Scale Armor", 20, 1, BigDecimal.valueOf(5000.00), 18);
			Gears gauntlets = GearsDao.create(cxn, "Gauntlets of Power", 12, 1, BigDecimal.valueOf(1800.00), 9);
			Gears shield = GearsDao.create(cxn, "Kite Shield", 8, 1, BigDecimal.valueOf(1200.00), 8);
			Gears belt = GearsDao.create(cxn, "Belt of Strength", 5, 1, BigDecimal.valueOf(900.00), 5);
			Gears amulet = GearsDao.create(cxn, "Amulet of Protection", 10, 1, BigDecimal.valueOf(2500.00), 7);
			Gears ring = GearsDao.create(cxn, "Ring of Wisdom", 9, 1, BigDecimal.valueOf(3200.00), 6);

			/*Insert Consumables*/
			Consumables smallHealthPotion = ConsumablesDao.create(cxn, "Small Health Potion", 1, 20, new BigDecimal("50.00"), "Restores 50 HP.");
			Consumables largeHealthPotion = ConsumablesDao.create(cxn, "Large Health Potion", 1, 20, new BigDecimal("75.00"), "Restores 100 HP.");
			Consumables manaPotion = ConsumablesDao.create(cxn, "Mana Potion", 1, 20, new BigDecimal("65.00"), "Restores 30 MP.");
			Consumables staminaPotion = ConsumablesDao.create(cxn, "Stamina Potion", 1, 20, new BigDecimal("55.00"), "Boosts stamina temporarily.");
			Consumables antidote = ConsumablesDao.create(cxn, "Antidote", 1, 15, new BigDecimal("40.00"), "Cures poison.");
			Consumables strengthPotion = ConsumablesDao.create(cxn, "Strength Potion", 5, 20, new BigDecimal("80.00"), "Increases strength by 15% for 5 minutes.");
			Consumables intelligenceElixir = ConsumablesDao.create(cxn, "Intelligence Elixir", 8, 10, new BigDecimal("120.00"), "Boosts spell damage by 20% for 3 minutes.");
			Consumables speedDraught = ConsumablesDao.create(cxn, "Speed Draught", 6, 15, new BigDecimal("95.00"), "Increases movement speed by 25% for 2 minutes.");
			Consumables toughnessTonic = ConsumablesDao.create(cxn, "Toughness Tonic", 7, 10, new BigDecimal("110.00"), "Reduces damage taken by 15% for 4 minutes.");
			Consumables focusTablet = ConsumablesDao.create(cxn, "Focus Tablet", 9, 5, new BigDecimal("150.00"), "Reduces all ability cooldowns by 30% for 1 minute.");
			Consumables restorationBrew = ConsumablesDao.create(cxn, "Restoration Brew", 10, 8, new BigDecimal("125.00"), "Heals 20% of max health and mana over 10 seconds.");
			Consumables invisibilityPotion = ConsumablesDao.create(cxn, "Invisibility Potion", 12, 3, new BigDecimal("200.00"), "Grants invisibility for 15 seconds.");
			
			//Insert Statistics
			Statistics strength = StatisticsDao.create(cxn, "Strength", "Determines physical power.");
			Statistics agility = StatisticsDao.create(cxn, "Agility", "Determines speed and dexterity.");
			Statistics intelligence = StatisticsDao.create(cxn, "Intelligence", "Determines magical ability.");
			Statistics endurance = StatisticsDao.create(cxn, "Endurance", "Determines stamina and resilience.");
			Statistics luck = StatisticsDao.create(cxn, "Luck", "Determines chance of critical hits.");			
			Statistics vitality = StatisticsDao.create(cxn, "Vitality", "Determines maximum health points.");
			Statistics wisdom = StatisticsDao.create(cxn, "Wisdom", "Determines mana regeneration and spell resistance.");
			Statistics perception = StatisticsDao.create(cxn, "Perception", "Determines accuracy and ability to spot hidden objects.");
			Statistics charisma = StatisticsDao.create(cxn, "Charisma", "Determines effectiveness in social interactions and trading.");
			Statistics focus = StatisticsDao.create(cxn, "Focus", "Determines ability to concentrate and maintain spells.");
			Statistics willpower = StatisticsDao.create(cxn, "Willpower", "Determines resistance to mental effects and status ailments.");
			Statistics dexterity = StatisticsDao.create(cxn, "Dexterity", "Determines hand-eye coordination and fine motor skills.");
			
			//Insert Currencies
			Currencies gold = CurrenciesDao.create(cxn, "Gold", new BigDecimal(1000.00), null);
			Currencies silver = CurrenciesDao.create(cxn, "Silver", null, new BigDecimal("100.00"));
			Currencies bronze = CurrenciesDao.create(cxn, "Bronze", null, null);
			Currencies platinum = CurrenciesDao.create(cxn, "Platinum",new BigDecimal(300.00), new BigDecimal(30.00));
			Currencies diamond = CurrenciesDao.create(cxn, "Diamond", new BigDecimal(50.00), new BigDecimal(5.00));
			Currencies copper = CurrenciesDao.create(cxn, "Copper", null, null);
			Currencies gemstone = CurrenciesDao.create(cxn, "Gemstone", new BigDecimal(100.00), null);
			Currencies token = CurrenciesDao.create(cxn, "Token", new BigDecimal(200.00), new BigDecimal(20.00));
			Currencies shard = CurrenciesDao.create(cxn, "Shard", null, new BigDecimal(30.00));
			Currencies essence = CurrenciesDao.create(cxn, "Essence", new BigDecimal(300.00), null);
			Currencies fragment = CurrenciesDao.create(cxn, "Fragment", null, new BigDecimal(25.00));
			Currencies ember = CurrenciesDao.create(cxn, "Ember", new BigDecimal(150.00), new BigDecimal(15.00));
			
			//Insert Characters
			Characters Char1 = CharactersDao.create(cxn, P1, "Alicia", "Storm", clan1, sword);
			Characters Char2 = CharactersDao.create(cxn, P2, "Boris", "Flame", clan2, axe);
			Characters Char3 = CharactersDao.create(cxn, P3, "Cecilia", "Wind", clan3, spear);
			Characters Char4 = CharactersDao.create(cxn, P4, "Derek", "Stone", clan4, bow);
			Characters Char5 = CharactersDao.create(cxn, P5, "Eva", "Night", clan5, dagger);
			Characters Char6 = CharactersDao.create(cxn, P6, "Marcus", "Storm", clan7, staff);
			Characters Char7 = CharactersDao.create(cxn, P7, "Elara", "Moon", clan8, sword);
			Characters Char8 = CharactersDao.create(cxn, P8, "Garrick", "Stone", clan9, katana);
			Characters Char9 = CharactersDao.create(cxn, P9, "Lyra", "Flame", clan10, crossbow);
			Characters Char10 = CharactersDao.create(cxn, P10, "Thorne", "Night", clan11, scythe);
			Characters Char11 = CharactersDao.create(cxn, P11, "Serena", "Wind", clan12, rapier);
			Characters Char12 = CharactersDao.create(cxn, P1, "Rowan", "Storm", clan1, mace);
			
		    //Insert CharacterStatistics
			CharacterStatistics charStat1 = CharacterStatisticsDao.create(cxn, Char1, strength, 10);
			CharacterStatistics charStat2 = CharacterStatisticsDao.create(cxn, Char2, agility, 12);
			CharacterStatistics charStat3 = CharacterStatisticsDao.create(cxn, Char3, intelligence, 15);
			CharacterStatistics charStat4 = CharacterStatisticsDao.create(cxn, Char4, endurance, 11);
			CharacterStatistics charStat5 = CharacterStatisticsDao.create(cxn, Char5, luck, 8);
			CharacterStatistics charStat6 = CharacterStatisticsDao.create(cxn, Char6, vitality, 14);
			CharacterStatistics charStat7 = CharacterStatisticsDao.create(cxn, Char7, wisdom, 13);
			CharacterStatistics charStat8 = CharacterStatisticsDao.create(cxn, Char8, perception, 9);
			CharacterStatistics charStat9 = CharacterStatisticsDao.create(cxn, Char9, charisma, 16);
			CharacterStatistics charStat10 = CharacterStatisticsDao.create(cxn, Char10, focus, 11);
			CharacterStatistics charStat11 = CharacterStatisticsDao.create(cxn, Char11, willpower, 12);
			CharacterStatistics charStat12 = CharacterStatisticsDao.create(cxn, Char12, dexterity, 10);
			// Additional stats for existing characters
			CharacterStatistics charStat13 = CharacterStatisticsDao.create(cxn, Char1, intelligence, 8);
			CharacterStatistics charStat14 = CharacterStatisticsDao.create(cxn, Char2, strength, 15);
			CharacterStatistics charStat15 = CharacterStatisticsDao.create(cxn, Char3, agility, 13);
			CharacterStatistics charStat16 = CharacterStatisticsDao.create(cxn, Char4, luck, 9);
			CharacterStatistics charStat17 = CharacterStatisticsDao.create(cxn, Char5, vitality, 14);
			
			//Insert EquipmentBonuse
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, sword.getItemID()), strength, 5);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, boots.getItemID()), agility, 3);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, spear.getItemID()), intelligence, 4);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, helmet.getItemID()), endurance, 11);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, axe.getItemID()), strength, 10);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, staff.getItemID()), intelligence, 8);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, warhammer.getItemID()), strength, 12);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, katana.getItemID()), agility, 9);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, crossbow.getItemID()), perception, 7);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, scythe.getItemID()), vitality, 6);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, helmet2.getItemID()), endurance, 9);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, chestplate.getItemID()), vitality, 14);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, gauntlets.getItemID()), strength, 8);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, shield.getItemID()), endurance, 10);
			EquipmentBonuseDao.create(cxn, EquipmentsDao.getEquipmentByItemID(cxn, rapier.getItemID()), dexterity, 11);

			//Insert ConsumableItemBonuse
			ConsumableItemBonuse sHealthPotionBonuse = ConsumableItemBonuseDao.create(cxn, smallHealthPotion, strength, 10, 15);
			ConsumableItemBonuse lHealthPotionBonuse = ConsumableItemBonuseDao.create(cxn, largeHealthPotion, intelligence, 8, 10);
			ConsumableItemBonuse manaPotionBonuse = ConsumableItemBonuseDao.create(cxn, manaPotion, endurance, 5, 8);
			ConsumableItemBonuse staminaPotionBonuse = ConsumableItemBonuseDao.create(cxn, staminaPotion, agility, 12, 18);
			ConsumableItemBonuse antidoteBonuse = ConsumableItemBonuseDao.create(cxn, antidote, luck, 20, 25);
			ConsumableItemBonuse strengthPotionBonus = ConsumableItemBonuseDao.create(cxn, strengthPotion, strength, 15, 20);
			ConsumableItemBonuse intelligenceElixirBonus = ConsumableItemBonuseDao.create(cxn, intelligenceElixir, intelligence, 18, 25);
			ConsumableItemBonuse speedDraughtBonus = ConsumableItemBonuseDao.create(cxn, speedDraught, agility, 20, 30);
			ConsumableItemBonuse toughnessTonicBonus = ConsumableItemBonuseDao.create(cxn, toughnessTonic, endurance, 15, 22);
			ConsumableItemBonuse focusTabletBonus = ConsumableItemBonuseDao.create(cxn, focusTablet, willpower, 25, 35);
			ConsumableItemBonuse restorationBrewBonus = ConsumableItemBonuseDao.create(cxn, restorationBrew, vitality, 22, 30);
			ConsumableItemBonuse invisibilityPotionBonus = ConsumableItemBonuseDao.create(cxn, invisibilityPotion, perception, 30, 40);
			
			//Insert JobsForGear
			JobsForGear JFG1 = JobsForGearDao.create(cxn, helmet, "Warrior");
			JobsForGear JFG2 = JobsForGearDao.create(cxn, armor, "Mage");
			JobsForGear JFG3 = JobsForGearDao.create(cxn, boots, "Archer");
			JobsForGear JFG4 = JobsForGearDao.create(cxn, gloves, "Thief");
			JobsForGear JFG5 = JobsForGearDao.create(cxn, legging, "Healer");
			JobsForGear JFG6 = JobsForGearDao.create(cxn, helmet2, "Paladin");
			JobsForGear JFG7 = JobsForGearDao.create(cxn, chestplate, "Samurai");
			JobsForGear JFG8 = JobsForGearDao.create(cxn, gauntlets, "Warrior");
			JobsForGear JFG9 = JobsForGearDao.create(cxn, shield, "Paladin");
			JobsForGear JFG10 = JobsForGearDao.create(cxn, belt, "Hunter");
			JobsForGear JFG11 = JobsForGearDao.create(cxn, amulet, "Necromancer");
			JobsForGear JFG12 = JobsForGearDao.create(cxn, ring, "Scholar");
			
			//Insert CharacterUnlockedJob
			CharacterUnlockedJob CUJ1 = CharacterUnlockedJobDao.create(cxn, Char1, "Warrior", 1, 100);
			CharacterUnlockedJob CUJ2 = CharacterUnlockedJobDao.create(cxn, Char1, "Mage", null, null);
			CharacterUnlockedJob CUJ3 = CharacterUnlockedJobDao.create(cxn, Char1, "Paladin", 1, 800);
			CharacterUnlockedJob CUJ4 = CharacterUnlockedJobDao.create(cxn, Char2, "Mage", 2, 200);
			CharacterUnlockedJob CUJ5 = CharacterUnlockedJobDao.create(cxn, Char2, "Paladin", 8, 800);
			CharacterUnlockedJob CUJ6 = CharacterUnlockedJobDao.create(cxn, Char3, "Archer", 3, 300);
			CharacterUnlockedJob CUJ7 = CharacterUnlockedJobDao.create(cxn, Char4, "Thief", 4, 400);
			CharacterUnlockedJob CUJ8 = CharacterUnlockedJobDao.create(cxn, Char5, "Healer", 5, 500);
			CharacterUnlockedJob CUJ9 = CharacterUnlockedJobDao.create(cxn, Char6, "Scholar", 7, 700);
			CharacterUnlockedJob CUJ10 = CharacterUnlockedJobDao.create(cxn, Char7, "Paladin", 8, 800);
			CharacterUnlockedJob CUJ11 = CharacterUnlockedJobDao.create(cxn, Char8, "Samurai", 9, 900);
			CharacterUnlockedJob CUJ12 = CharacterUnlockedJobDao.create(cxn, Char9, "Hunter", 10, 1000);
			CharacterUnlockedJob CUJ13 = CharacterUnlockedJobDao.create(cxn, Char10, "Necromancer", 11, 1100);
			CharacterUnlockedJob CUJ14 = CharacterUnlockedJobDao.create(cxn, Char3, "Warrior", null, null);
			CharacterUnlockedJob CUJ15 = CharacterUnlockedJobDao.create(cxn, Char10, "Mage", 3, 250);
			CharacterUnlockedJob CUJ16 = CharacterUnlockedJobDao.create(cxn, Char11, "Fencer", 6, 600);
			CharacterUnlockedJob CUJ17 = CharacterUnlockedJobDao.create(cxn, Char12, "Cleric", 7, 700);
			CharacterUnlockedJob CUJ18 = CharacterUnlockedJobDao.create(cxn, Char7, bow.getWearableJob(), 2, 200);
			CharacterUnlockedJob CUJ19 = CharacterUnlockedJobDao.create(cxn, Char7, mace.getWearableJob(), 7, 400);
			
			//Insert CharacterWealth
			CharacterWealth CW1 = CharacterWealthDao.create(cxn, Char1, gold, new BigDecimal(500.00), new BigDecimal(50.00));
			CharacterWealth CW2 = CharacterWealthDao.create(cxn, Char2, silver, new BigDecimal(1000.00), new BigDecimal(100.00));
			CharacterWealth CW3 = CharacterWealthDao.create(cxn, Char3, bronze, new BigDecimal(300.00), new BigDecimal(30.00));
			CharacterWealth CW4 = CharacterWealthDao.create(cxn, Char4, platinum, new BigDecimal(150.00), new BigDecimal(15.00));
			CharacterWealth CW5 = CharacterWealthDao.create(cxn, Char5, diamond, new BigDecimal(20.00), null);
			CharacterWealth CW6 = CharacterWealthDao.create(cxn, Char6, gold, new BigDecimal(750.00), new BigDecimal(75.00));
			CharacterWealth CW7 = CharacterWealthDao.create(cxn, Char7, silver, new BigDecimal(1500.00), new BigDecimal(150.00));
			CharacterWealth CW8 = CharacterWealthDao.create(cxn, Char8, bronze, new BigDecimal(450.00), new BigDecimal(45.00));
			CharacterWealth CW9 = CharacterWealthDao.create(cxn, Char9, platinum, new BigDecimal(200.00), new BigDecimal(20.00));
			CharacterWealth CW10 = CharacterWealthDao.create(cxn, Char10, diamond, new BigDecimal(30.00), null);
			CharacterWealth CW11 = CharacterWealthDao.create(cxn, Char11, copper, new BigDecimal(600.00), new BigDecimal(60.00));
			CharacterWealth CW12 = CharacterWealthDao.create(cxn, Char12, gemstone, new BigDecimal(50.00), null);
			// Additional currencies for existing characters
			CharacterWealth CW13 = CharacterWealthDao.create(cxn, Char1, token, new BigDecimal(120.00), new BigDecimal(12.00));
			CharacterWealth CW14 = CharacterWealthDao.create(cxn, Char2, shard, new BigDecimal(80.00), new BigDecimal(8.00));
			CharacterWealth CW15 = CharacterWealthDao.create(cxn, Char3, essence, new BigDecimal(200.00), null);
			CharacterWealth CW16 = CharacterWealthDao.create(cxn, Char4, fragment, new BigDecimal(150.00), new BigDecimal(15.00));
			CharacterWealth CW17 = CharacterWealthDao.create(cxn, Char5, ember, new BigDecimal(100.00), new BigDecimal(10.00));
			CharacterWealth CW18 = CharacterWealthDao.create(cxn, Char6, shard, new BigDecimal(350.00), new BigDecimal(35.00));
			CharacterWealth CW19 = CharacterWealthDao.create(cxn, Char7, token, new BigDecimal(250.00), new BigDecimal(25.00));
			
			
			//Insert Inventory
			Inventory inven1 = InventoryDao.create(cxn, Char1, 1, armor, 1);
			Inventory inven20 = InventoryDao.create(cxn, Char7, 1, mace, 1);
			Inventory inven21 = InventoryDao.create(cxn, Char7, 3, bow, 1);
			Inventory inven2 = InventoryDao.create(cxn, Char2, 2, boots, 1);
			Inventory inven3 = InventoryDao.create(cxn, Char3, 3, spear, 1);
			Inventory inven4 = InventoryDao.create(cxn, Char4, 4, gloves, 1);
			Inventory inven5 = InventoryDao.create(cxn, Char5, 5, helmet, 1);
			//Insert more Inventory items
			Inventory inven6 = InventoryDao.create(cxn, Char6, 1, staff, 1);
			Inventory inven7 = InventoryDao.create(cxn, Char7, 2, warhammer, 1);
			Inventory inven8 = InventoryDao.create(cxn, Char8, 3, helmet2, 1);
			Inventory inven9 = InventoryDao.create(cxn, Char9, 4, chestplate, 1);
			Inventory inven10 = InventoryDao.create(cxn, Char10, 5, gauntlets, 1);
			Inventory inven11 = InventoryDao.create(cxn, Char11, 6, shield, 1);
			Inventory inven12 = InventoryDao.create(cxn, Char12, 7, belt, 1);
			// Add consumables to inventories
			Inventory inven13 = InventoryDao.create(cxn, Char1, 10, smallHealthPotion, 5);
			Inventory inven14 = InventoryDao.create(cxn, Char2, 11, largeHealthPotion, 3);
			Inventory inven15 = InventoryDao.create(cxn, Char3, 12, manaPotion, 7);
			Inventory inven16 = InventoryDao.create(cxn, Char4, 13, staminaPotion, 4);
			Inventory inven17 = InventoryDao.create(cxn, Char5, 14, antidote, 2);
			Inventory inven18 = InventoryDao.create(cxn, Char6, 15, strengthPotion, 6);
			Inventory inven19 = InventoryDao.create(cxn, Char7, 16, intelligenceElixir, 3);


			//Insert EquippedItems
			// For Char1 (Warrior with sword)
			EquippedItems equippedItem1 = EquippedItemsDao.create(cxn, Char1, "HEAD", helmet);
			EquippedItems equippedItem1b = EquippedItemsDao.create(cxn, Char1, "BODY", armor);
			EquippedItems equippedItem1c = EquippedItemsDao.create(cxn, Char1, "HAND", gloves);
			// For Char2 (Mage with axe)
			EquippedItems equippedItem2 = EquippedItemsDao.create(cxn, Char2, "BODY", armor);
			EquippedItems equippedItem2b = EquippedItemsDao.create(cxn, Char2, "HEAD", helmet2);
			EquippedItems equippedItem2c = EquippedItemsDao.create(cxn, Char2, "NECK", amulet);
			// For Char3 (Archer with spear)
			EquippedItems equippedItem3 = EquippedItemsDao.create(cxn, Char3, "FOOT", boots);
			EquippedItems equippedItem3b = EquippedItemsDao.create(cxn, Char3, "HEAD", helmet);
			EquippedItems equippedItem3c = EquippedItemsDao.create(cxn, Char3, "WAIST", belt);
			// For Char4 (Thief with bow)
			EquippedItems equippedItem4 = EquippedItemsDao.create(cxn, Char4, "HAND", gloves);
			EquippedItems equippedItem4b = EquippedItemsDao.create(cxn, Char4, "FOOT", boots);
			EquippedItems equippedItem4c = EquippedItemsDao.create(cxn, Char4, "FINGER", ring);
			// For Char5 (Healer with dagger)
			EquippedItems equippedItem5 = EquippedItemsDao.create(cxn, Char5, "LEG", legging);
			EquippedItems equippedItem5b = EquippedItemsDao.create(cxn, Char5, "NECK", amulet);
			EquippedItems equippedItem5c = EquippedItemsDao.create(cxn, Char5, "WRIST", ring);
			// For Char6 (Scholar with staff)
			EquippedItems equippedItem6a = EquippedItemsDao.create(cxn, Char6, "HEAD", helmet2);
			EquippedItems equippedItem6b = EquippedItemsDao.create(cxn, Char6, "BODY", chestplate);
			EquippedItems equippedItem6c = EquippedItemsDao.create(cxn, Char6, "FINGER", ring);
			// For Char7 (Paladin with warhammer)
			EquippedItems equippedItem7a = EquippedItemsDao.create(cxn, Char7, "HEAD", helmet);
			EquippedItems equippedItem7b = EquippedItemsDao.create(cxn, Char7, "BODY", armor);
			EquippedItems equippedItem7c = EquippedItemsDao.create(cxn, Char7, "HAND", gauntlets);
			EquippedItems equippedItem7d = EquippedItemsDao.create(cxn, Char7, "LEG", legging);
			EquippedItems equippedItem7e = EquippedItemsDao.create(cxn, Char7, "OFF_HAND", shield);
			// For Char8 (Samurai with katana)
			EquippedItems equippedItem8a = EquippedItemsDao.create(cxn, Char8, "HEAD", helmet2);
			EquippedItems equippedItem8b = EquippedItemsDao.create(cxn, Char8, "BODY", chestplate);
			EquippedItems equippedItem8c = EquippedItemsDao.create(cxn, Char8, "HAND", gauntlets);
			// For Char9 (Hunter with crossbow)
			EquippedItems equippedItem9a = EquippedItemsDao.create(cxn, Char9, "HEAD", helmet);
			EquippedItems equippedItem9b = EquippedItemsDao.create(cxn, Char9, "BODY", armor);
			EquippedItems equippedItem9c = EquippedItemsDao.create(cxn, Char9, "FOOT", boots);
			EquippedItems equippedItem9d = EquippedItemsDao.create(cxn, Char9, "WAIST", belt);
			// For Char10 (Necromancer with scythe)
			EquippedItems equippedItem10a = EquippedItemsDao.create(cxn, Char10, "HEAD", helmet2);
			EquippedItems equippedItem10b = EquippedItemsDao.create(cxn, Char10, "NECK", amulet);
			EquippedItems equippedItem10c = EquippedItemsDao.create(cxn, Char10, "FINGER", ring);
			// For Char11 (Fencer with rapier)
			EquippedItems equippedItem11a = EquippedItemsDao.create(cxn, Char11, "BODY", armor);
			EquippedItems equippedItem11b = EquippedItemsDao.create(cxn, Char11, "HAND", gauntlets);
			EquippedItems equippedItem11c = EquippedItemsDao.create(cxn, Char11, "FOOT", boots);
			// For Char12 (Cleric with mace)
			EquippedItems equippedItem12a = EquippedItemsDao.create(cxn, Char12, "HEAD", helmet);
			EquippedItems equippedItem12b = EquippedItemsDao.create(cxn, Char12, "BODY", chestplate);
			EquippedItems equippedItem12c = EquippedItemsDao.create(cxn, Char12, "OFF_HAND", shield);
			
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
		    Consumables cons = ConsumablesDao.getConsumableByItemID(cxn, smallHealthPotion.getItemID());
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
		    
		    // get a list of all characters 
		    List<Characters> characters = CharactersDao.getAllCharacters(cxn, "characterfirstname", "ASC");
		    System.out.print("\n\nget a list of all characters:");
		    for (Characters c : characters) {
		    	System.out.format("%n	%s", c.toString());
		    }
		    // get characters by playerIDs
		    List<Integer> playerIDs = new ArrayList<>(List.of(1, 2));
		    List<Characters> charactersByPlayerIDs = CharactersDao.getCharactersByPlayerIDs(cxn, playerIDs, "characterfirstname", "asc");
		    System.out.print("\n\nget a list of all characters of players with ids 1, 2:");
		    for (Characters c : charactersByPlayerIDs) {
		    	System.out.format("%n	%s", c.toString());
		    }

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
