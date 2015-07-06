//
//  ViewController.swift
//  iOS_Assignment 4
//
//  Created by Felix Beifuss on 06/07/15.
//  Copyright (c) 2015 Felix Beifuss. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var myLabel: UILabel!
    @IBOutlet weak var myTextField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        self.myTextField.delegate = self;
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func returnPressed(textField: UITextField) -> Bool {
        self.view.endEditing(true)
        return false
    }
    
    override func touchesBegan(touches: Set<NSObject>, withEvent event: UIEvent) {
        myTextField.resignFirstResponder()
    }
    

    @IBAction func buttonClicked(sender: AnyObject) {
        myLabel.text = "hi \(myTextField.text)"
    }

    // Loesung von gerlicher
    func enterPressed(sender: AnyObject) {
        myTextField.resignFirstResponder()
    }
}

