//
//  ViewController.swift
//  MAD_iOS_myFirstApp
//
//  Created by Felix Beifuss on 18/05/15.
//  Copyright (c) 2015 Felix Beifuss. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var myLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func myButtonTouched(sender: UIButton) {
        myLabel.text = "Hello swift."
    }
    
    override func touchesBegan(touches: Set<NSObject>, withEvent event: UIEvent) {
        myLabel.text = "touch began"
    }
    
    override func touchesEnded(touches: Set<NSObject>, withEvent event: UIEvent) {
        myLabel.text = "touch ended"
    }
    
    override func touchesCancelled(touches: Set<NSObject>!, withEvent event: UIEvent!) {
        myLabel.text = "touch canceled"
    }
    
    override func touchesMoved(touches: Set<NSObject>, withEvent event: UIEvent) {
        myLabel.text = "touch moved."
    }

}

