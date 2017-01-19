package asm;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandles.Lookup;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Handle;

public class DynInvokerSample extends ClassLoader{
	
	private static final int H_INVOKERSTATIC = 0;
	
	private static final Handle bsm = new Handle(H_INVOKERSTATIC,DynBootStrap.class.getName().replace('.','/'),"bootstrap",MethodType.methodType(CallSite.class,Lookup.class,String.class,MethodType.class,Object.class).toMethodDescriptorString());

	public Class createClass() throws Exception{
		
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
//		cw.visit(version, access, name, signature, superName, interfaces);
		return null;
		
	}
	
}