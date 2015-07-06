//: Playground - noun: a place where people can play

import UIKit

protocol FriendlyPerson {
    func sayHi() -> String
}

class Person : FriendlyPerson{

    var firstName : String
    var lastName  : String
    
    var fullName : String {
        get {
            return "\(firstName) \(lastName)"
        }
        set(fName) {
            var fNameArray = fName.componentsSeparatedByString(" ")
            firstName = fNameArray[0]
            lastName  = fNameArray[1]
        }
    }
    
    init(fName : String, lName : String) {
        firstName = fName
        lastName  = lName
    }
    
    func sayHi() -> String {
        var output = "\(firstName) says hi"
        return output
    }
    
}



let person = Person(fName: "Felix", lName: "Beifuss")

println("\(person.sayHi())")

