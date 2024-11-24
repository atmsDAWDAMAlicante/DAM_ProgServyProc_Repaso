using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading.Tasks;

namespace Repaso02
	{
	internal class Fibonacci
		{
		public static async Task Main(String[] args)
			{
			// Calculamos la suma de la secuencia fibonacci
			long resultado = FibonacciMetodo(40);
			Console.WriteLine("El resultado de la suma de la secuencia de Fibonacci es: " + resultado);

			// Mostramos los números del 1 al 10
			Console.WriteLine("Mostrando los números del 1 al 10");
			for (int i = 0; i < 10; i++)
				{
				Console.WriteLine(i);
				await Task.Delay(1000);

				}
			}

		static long FibonacciMetodo(int n)
			{
				if (n <= 1)
					return n;
				else
					return FibonacciMetodo(n-1) + FibonacciMetodo(n-2);
			}
		}
	}
