//
//  main.swift
//  iOS_Assignment2
//
//  Created by Felix Beifuss on 02/07/15.
//  Copyright (c) 2015 Felix Beifuss. All rights reserved.
//

import Foundation

func input() -> String {
    var keyboard = NSFileHandle.fileHandleWithStandardInput()
    var inputData = keyboard.availableData
    var strData = NSString(data: inputData, encoding: NSUTF8StringEncoding)!
    
    return strData.stringByTrimmingCharactersInSet(NSCharacterSet.newlineCharacterSet())
}

println("please think of a number between 0 and 1000")


var textInput : String
var min = 0;
var max = 1000;
var currentValue = 500;
var counter = 0;

var gameIsOn = true

while gameIsOn {

    currentValue = min + (max-min) / 2
    counter++
    
    println("Is the number \(currentValue) (g)reater or (s)maller than your number or is it (c)orrect?")
    textInput = input()
    switch textInput {
        case "g":
            max = currentValue
        case "s":
            min = currentValue
        case "c":
            println("yay! it only took \(counter) time(s)!")
            gameIsOn = false
        default:
            println("Please only type g,s or c")
            counter--
    }
}

