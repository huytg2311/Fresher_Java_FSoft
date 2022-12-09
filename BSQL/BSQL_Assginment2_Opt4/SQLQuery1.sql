use AdventureWorks2008;

-- Exercise 1: ------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------

-- Query 1
select ProductID, [Name], Color, ListPrice from Production.Product;

-- Query 2
select ProductID, [Name], Color, ListPrice from Production.Product where ListPrice != 0;

-- Query 3
select ProductID, [Name], Color, ListPrice from Production.Product where Color is null;

-- Query 4
select ProductID, [Name], Color, ListPrice from Production.Product where Color is not null;

-- Query 5
select ProductID, [Name], Color, ListPrice from Production.Product where Color is not null and ListPrice > 0;

-- Query 6
select [Name], Color from Production.Product where Color is not null;

-- Query 7
select CONCAT('NAME: ',[Name]) Name , CONCAT('COLOR: ', Color) Color from Production.Product where Color is not null;

-- Query 8
select ProductID, [Name] from Production.Product where ProductID >= 400 and ProductID <= 500;

-- Query 9
select ProductID, [Name], Color from Production.Product where Color = 'Black' or Color = 'Blue';

-- Query 10
select [Name], ListPrice from Production.Product where [Name] like 's%' order by [Name] asc;

-- Query 11
select [Name], ListPrice from Production.Product where [Name] like 's%' or [Name] like 'a%' order by [Name] asc;

-- Query 13
select [Name], ListPrice from Production.Product where [Name] like 'Spo%' and [Name] not like '___k%' order by [Name] asc;

-- Query 14
select DISTINCT ProductSubcategoryID,  Color from Production.Product where ProductSubcategoryID is not null and Color is not null

-- Query 15
SELECT ProductSubCategoryID
      , LEFT([Name],35) AS [Name]
      , Color, ListPrice
FROM Production.Product
WHERE (ProductSubCategoryID = 1 and Color IN ('Red','Black')) or ListPrice BETWEEN 1000 AND 2000 
ORDER BY ProductID;

-- Query 16
select [Name], COALESCE(Color, 'Unknown') as Color, ListPrice from Production.Product;

-- ---------------------------------------------------------------------------------------------
-- Exercise 2 ----------------------------------------------------------------------------------

-- Query 1:
select count(*) as so_luong from Production.Product;

-- Query 2:
select count(*) as HasSubCategoryID from Production.Product where ProductSubCategoryID is not null;

-- Query 3:
select ProductSubcategoryID, count(ProductID) as CountedProducts from Production.Product group by ProductSubcategoryID;

-- Query 4:
select count(*) as CountedProducts from Production.Product where ProductSubcategoryID is null;


-- Query 5:
select ProductID, sum(Quantity) as TheSum from Production.ProductInventory group by(ProductID);

-- Query 6:
select ProductID, sum(Quantity) as TheSum from Production.ProductInventory where LocationID = 40 group by (ProductID) having sum(Quantity) < 100;

-- Query 7:
select Shelf, ProductID, sum(Quantity) as TheSum from Production.ProductInventory where LocationID = 40 group by (ProductID), (Shelf) having sum(Quantity) < 100;

-- Query 8:
select AVG(Quantity) as TheAvg from Production.ProductInventory where LocationID = 10;

-- Query 9:
select ProductID, Shelf, avg(Quantity) as TheAvg from Production.ProductInventory where LocationID = 10 and Shelf != 'N/A' 
group by rollup (ProductID) order by Shelf asc;

-- Query 10:
 select color, class, count(*) as TheCount,
 avg(ListPrice) as AVGPrice
 from Production.Product
 where Class is not null and Color is not null
 group by GROUPING SETS ((Color), (Class));

-- Query 11:
 Select ProductSubcategoryID, count(Name) as Counted,
 Grouping(ProductSubcategoryID) as IsgrandTotal
 from Production.Product
 group by rollup (ProductSubcategoryID)
 order by ProductSubcategoryID;


