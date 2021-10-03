package cen4010.pa1;
/*a constructor that takes the x, y, and z coordinates, which should be doubles.
Vector3D scale(double f); which should multiply x, y, and z by a common factor f.
Vector3D add(Vector3D v); which takes one Vector3D as an argument adds the corresponding coordinates to its own and produces a new Vector3D ( {x0, y0, z0} + {x1, y1, z1} = {x0+x1, y0+y1, z0+z1}, where x0, y0, and z0 are "this" object's coordinates and x1, y1, and z1 are the argument v's coordinates) .
Vector3D subtract(Vector3D v); Like add except you subtract argument v's coordinates from the corresponding coordinates in "this" producing a new Vector3D object.
Vector3D negate(); This is shorthand for scale by -1.
double dot(Vector3D v); Produce the dot product of "this" Vector3D and argument Vector3D v ( {x0, y0, z0} dot {x1, y1, z1} = x0*x1 + y0*y1 + z0*z1 ).
double magnitude(); returns the magnitude of a Vector3D ( sqrt(x*x + y*y + z*z) ).
Provide a toString method for reasonable output.
Provide an implementation of equals. Remember that float and double arithmetic is not exact. Thus, you must allow for a tolerance.
*/

import static java.lang.Math.sqrt;

public class Vector3D {
double x;
double y;
double z;
	
	//a constructor that takes the x, y, and z coordinates, which should be doubles.
	public Vector3D(double x,double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	//Vector3D scale(double f); which should multiply x, y, and z by a common factor f.
	public Vector3D scale (double f)
	{
		return new Vector3D(this.x*f,this.y*f,this.z*f);
	}
	
	//Vector3D add(Vector3D v); which takes one Vector3D as an argument adds the corresponding coordinates to its own and produces a new Vector3D ( {x0, y0, z0} + {x1, y1, z1} = {x0+x1, y0+y1, z0+z1}, where x0, y0, and z0 are "this" object's coordinates and x1, y1, and z1 are the argument v's coordinates) .
	public Vector3D add (Vector3D v)
	{
		return (new Vector3D(this.x+v.x,this.y+v.y,this.z+v.z));
	}
	//Vector3D subtract(Vector3D v); Like add except you subtract argument v's coordinates from the corresponding coordinates in "this" producing a new Vector3D object.
	public Vector3D subtract (Vector3D v)
	{
		return (new Vector3D(this.x-v.x,this.y-v.y,this.z-v.z));
	}
	
	//Vector3D negate(); This is shorthand for scale by -1.
	public Vector3D negate ()
	{
		return new Vector3D(this.x*-1,this.y*-1,this.z*-1);
		
	}
	//double dot(Vector3D v); Produce the dot product of "this" Vector3D and argument Vector3D v ( {x0, y0, z0} dot {x1, y1, z1} = x0*x1 + y0*y1 + z0*z1 ).
	public double dot (Vector3D v)
	{
		return (this.x*v.x+this.y*v.y+this.z*v.z);
	}
	
	//double magnitude(); returns the magnitude of a Vector3D ( sqrt(x*x + y*y + z*z) ).
	public double magnitude ()
	{
		
		return (sqrt(this.x*this.x + this.y*this.y + this.z*this.z));
	}
	
	//Provide a toString method for reasonable output.
	public String toString ()
	{
		return("["+(this.x)+"],["+(this.y)+"],["+(this.z)+"]");
	}
	
	//Provide an implementation of equals. Remember that float and double arithmetic is not exact. Thus, you must allow for a tolerance.
	public boolean equals (Vector3D v)
	{
		
		if (((Math.floor(this.x * 100) / 100)==(Math.floor(v.x * 100) / 100)) && ((Math.floor(this.y * 100) / 100)==(Math.floor(v.y * 100) / 100)) && ((Math.floor(this.z * 100) / 100)==(Math.floor(v.z * 100) / 100)))
		{
			return true;
		}
		else 
			return false;
	}
}
