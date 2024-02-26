
package com.example.FacturacionEntregaProyectoFinalCanon;

import java.math.BigDecimal;

public class GFG {
	public static void main(String[] args)
    {

        BigDecimal sum;
  
        String input1
            = "0.0";
        String input2
            = "4256456484464684864864";
  

        BigDecimal a
            = new BigDecimal(input1);
        BigDecimal b
            = new BigDecimal(input2);

        sum = a.add(b);

        System.out.println("The sum of\n"
                           + a + " \nand\n" + b + " "
                           + "\nis\n" + sum + "\n");
    }
}
