//: Playground - noun: a place where people can play

import UIKit

class Person {
    
    var firstName : String = "Felix"
    var lastName  : String = "Beifuss"
    
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
    
}


let person = Person()
println("Firstname: \(person.firstName) Lastname: \(person.lastName)")
println("Fullname: \(person.fullName)")

person.fullName = "Adolf Hitler"
println("Firstname: \(person.firstName) Lastname: \(person.lastName)")
println("Fullname: \(person.fullName)")
