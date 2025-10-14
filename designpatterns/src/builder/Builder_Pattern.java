package builder;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohammed
 */
public class Builder_Pattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create director and builders

		Director director = new Director();



		Builder b1 = new ConcreteBuilder1();

		Builder b2 = new ConcreteBuilder2();



		// getPizza two products

		director.Construct(b1);

		Product p1 = b1.GetResult();

		p1.Show();



		director.Construct(b2);

		Product p2 = b2.GetResult();

		p2.Show();

        
        // TODO code application logic here
    }
     
}
abstract class Builder
{

	public abstract void BuildPartA();

	public abstract void BuildPartB();

	public abstract Product GetResult();

}

     class ConcreteBuilder1 extends Builder
{

	private Product _product = new Product();



	@Override
	public void BuildPartA()
	{

		_product.Add("PartA");

	}



	@Override
	public void BuildPartB()
	{

		_product.Add("PartB");

	}



	@Override
	public Product GetResult()
	{

		return _product;

	}

}

 class ConcreteBuilder2 extends Builder
{

	private Product _product = new Product();



	@Override
	public void BuildPartA()
	{

		_product.Add("PartX");

	}



	@Override
	public void BuildPartB()
	{

		_product.Add("PartY");

	}



	@Override
	public Product GetResult()
	{

		return _product;

	}

}
 class Director
{

	// builder.Builder uses a complex series of steps

	public final void Construct(Builder builder)
	{

		builder.BuildPartA();

		builder.BuildPartB();

	}

}
 class Product
{

	private java.util.ArrayList<String> _parts = new java.util.ArrayList<String>();


	public final void Add(String part)
	{

		_parts.add(part);

	}



	public final void Show()
	{

		System.out.println("\nbuilder.Product Parts -------");

		for (String part : _parts)

		{
			System.out.println(part);
		}

	}

}

