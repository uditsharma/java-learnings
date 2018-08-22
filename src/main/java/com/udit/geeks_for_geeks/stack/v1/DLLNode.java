/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.stack.v1;

/**
 * @author Udit Sharma.
 * @since 16 Feb, 2018 11:39 PM
 */
public class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int data) {
        this.data = data;
    }
}
