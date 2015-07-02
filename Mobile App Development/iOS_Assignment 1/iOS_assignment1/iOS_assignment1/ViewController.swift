//
//  ViewController.swift
//  iOS_assignment1
//
//  Created by Felix Beifuss on 02/07/15.
//  Copyright (c) 2015 Felix Beifuss. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var count = 0

    @IBAction func buttonPressed(sender: UIButton) {
        count++
        myLabel.text = "you clicked \(count) times."
    }
    
    @IBOutlet weak var myLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

