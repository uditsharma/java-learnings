/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.stack.v1;

import java.util.Stack;

/**
 * @author Udit Sharma.
 * @since 16 Feb, 2018 11:11 PM
 */
public class SpecialStack extends Stack<Integer> {
    private Stack<Integer> min = new Stack<>();

    @Override
    public Integer push(Integer item) {
        if (item != null) {
            Integer minimumValue = null;
            if (!min.isEmpty()) {
                minimumValue = min.peek();
            }
            if (minimumValue == null || minimumValue >= item) {
                min.push(item);
            }
            return super.push(item);
        }
        return null;
    }

    @Override
    public synchronized Integer pop() {
        return super.pop();
    }

    public Integer getMin() {
        if (!min.isEmpty()) {
            return min.pop();
        }
        return -1;
    }
}
