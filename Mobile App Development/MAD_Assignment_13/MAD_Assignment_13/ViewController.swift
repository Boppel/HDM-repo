//
//  ViewController.swift
//  MAD_Assignment_13
//
//  Created by Felix Beifuss on 08/06/15.
//  Copyright (c) 2015 Felix Beifuss. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var myOutputLabel: UILabel!
    @IBOutlet var myInputField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        myInputField.delegate = self
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func buttonPressed(sender: AnyObject) {
        myOutputLabel.text = "Hello " + myInputField.text
    }
    
    // for return on keyboard
    func textFieldShouldReturn(textField: UITextField) -> Bool {
        myInputField.resignFirstResponder()
        return true;
    }
    
    // for touch somewhere else
    override func touchesBegan(touches: Set<NSObject>, withEvent event: UIEvent) {
        myInputField.resignFirstResponder()
        self.view.endEditing(true)
    }
     
    

}

