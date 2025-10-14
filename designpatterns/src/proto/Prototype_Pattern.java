/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prototype_pattern;


public class Prototype_Pattern {

   
public static void main(String[] args) 
{
         ConcretePrototype1 p1 = new ConcretePrototype1("I");

		ConcretePrototype1 c1 = (ConcretePrototype1)p1.Clone();

		System.out.printf("Cloned: %1$s" + "\r\n", c1.getId());



		ConcretePrototype2 p2 = new ConcretePrototype2("II");

		ConcretePrototype2 c2 = (ConcretePrototype2)p2.Clone();

		System.out.printf("Cloned: %1$s" + "\r\n", c2.getId());

        // TODO code application logic here
        // TODO code application logic here
    }
}

 abstract class Prototype
{

	private String _id;



	// Constructor

	public Prototype(String id)
	{

		this._id = id;

	}



	// Gets id


	public final String getId()
	{
		return _id;
	}




	public abstract Prototype Clone();

}
 class ConcretePrototype1 extends Prototype
{

	// Constructor

	public ConcretePrototype1(String id)
	{
		super(id);

	}



	// Returns a shallow copy

	@Override
	public Prototype Clone()
	{   Prototype P= new ConcretePrototype1("I");
		return P;

	}

}   
 class ConcretePrototype2 extends Prototype
{

	// Constructor

	public ConcretePrototype2(String id)
	{
		super(id);

	}



	// Returns a shallow copy

	@Override
	public Prototype Clone()
	{

        Prototype P= new ConcretePrototype2("II");
		return P;
	}
 }

