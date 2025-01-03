package com.scaler.nov_myprojectmodule.exceptions;
//           Child class                     base class provide by spring
public class ProductNotFoundException extends Exception {

    //create an object of ProductNotFoundException class and
    //set the error message
    public ProductNotFoundException(String message) {
        // by using super keyword we set the exception for error
        super(message);
    }
}
