package test;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class TestAxis2 {

	public static void main(String[] args) throws AxisFault  {
		// TODO Auto-generated method stub
		// 使用RPC方式调用WebService
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		// 指定调用WebService的URL
		EndpointReference targetEPR = new EndpointReference("http://localhost:8088/springmvc/services/HelloWorldService");
		options.setTo(targetEPR);
		// 指定sayHelloToPerson方法的参数值
		Object[] opAddEntryArgs = new Object[] { "美女" };
		// 指定sayHelloToPerson方法返回值的数据类型的Class对象
		Class[] classes = new Class[] { String.class };
		// 指定要调用的sayHelloToPerson方法及WSDL文件的命名空间
		QName opAddEntry = new QName("http://impl.service.springmvc.com", "sayHello");
		// 调用sayHelloToPerson方法并输出该方法的返回值
		System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
	}

}
