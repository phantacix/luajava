/*******************************************************************************
* Copyright (c) 2009-2011 Luaj.org. All rights reserved.
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
******************************************************************************/
package org.luaj.vm2.lib.jme;

import java.io.IOException;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.IoLib;
import org.luaj.vm2.lib.LibFunction;

/** 
 * Subclass of {@link IoLib} and therefore {@link LibFunction} which implements the lua standard {@code io} 
 * library for the JSE platform. 
 * <p> 
 * The implementation of the is based on CLDC 1.0 and StreamConnection.
 * However, seek is not supported. 
 * <p>
 * Typically, this library is included as part of a call to 
 * {@link JmePlatform#standardGlobals()}
 * <pre> {@code
 * Globals globals = JmePlatform.standardGlobals();
 * globals.get("io").get("write").call(LuaValue.valueOf("hello, world\n"));
 * } </pre>
 * <p>
 * For special cases where the smallest possible footprint is desired, 
 * a minimal set of libraries could be loaded
 * directly via {@link Globals#load(LuaValue)} using code such as:
 * <pre> {@code
 * Globals globals = new Globals();
 * globals.load(new JmeBaseLib());
 * globals.load(new PackageLib());
 * globals.load(new JmeIoLib());
 * globals.get("io").get("write").call(LuaValue.valueOf("hello, world\n"));
 * } </pre>
 * <p>However, other libraries such as <em>MathLib</em> are not loaded in this case.
 * <p>
 * This has been implemented to match as closely as possible the behavior in the corresponding library in C.
 * @see LibFunction
 * @see org.luaj.vm2.lib.jse.JsePlatform
 * @see JmePlatform
 * @see IoLib
 * @see JseIoLib
 * @see <a href="http://www.lua.org/manual/5.2/manual.html#6.8">Lua 5.2 I/O Lib Reference</a>
 */
public class JmeIoLib extends IoLib {
	

	protected File openFile( String filename, boolean readMode, boolean appendMode, boolean updateMode, boolean binaryMode ) throws IOException {
		/*
		String url = "file:///" + filename;
		int mode  = readMode? Connector.READ: Connector.READ_WRITE;
		StreamConnection conn = (StreamConnection) Connector.open( url, mode );
		File f = readMode? 
				new FileImpl(conn, conn.openInputStream(), null):
				new FileImpl(conn, conn.openInputStream(), conn.openOutputStream());
		/*
		if ( appendMode ) {
			f.seek("end",0);
		} else {
			if ( ! readMode )
				conn.truncate(0);
		}
		*/
		//return f;
		return null;
	}
	
	private static void notimplemented() throws IOException {
		throw new IOException("not implemented");
	}
	
	protected File openProgram(String prog, String mode) throws IOException {
		notimplemented();
		return null;
	}

	protected File tmpFile() throws IOException {
		notimplemented();
		return null;
	}

	@Override
	protected File wrapStdin() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected File wrapStdout() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected File wrapStderr() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
