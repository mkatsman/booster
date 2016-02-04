# booster
Initial assignment is here:
https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/README.md 

I created the my directory and put all my implementation in there, leaving the initial implementation outside. 
I added MyItem class, which extends an Item and adds a new field called type. 
Created an ItemProcessor interface and the concrete class for each type, which implements the updateQuality method. 
ItemProcessorFactory produces a processor for each item type. 
The default type is GENERAL. 
All tests are located  in MyGuildedRoseTest class.