//: Playground - noun: a place where people can play

import UIKit

var str = "Hello, playground"


var shoppingList = [String]()

shoppingList.append("Bread")
shoppingList.append("Milk")
shoppingList.append("Lemons")
shoppingList.append("Butter")
shoppingList.append("Salad")

for (index, value) in enumerate(shoppingList) {
    println("Item no. \(index) in shopping list: \(value)")
}

println("Removing item \(shoppingList.count - 1)")
shoppingList.removeLast();

println("shopping list now has \(shoppingList.count) items")
