package PatikaStore;

public class Notebook extends Product
{
    public Notebook()
    {
        super();
    }

    public Notebook(String name,
                  Brand brand,
                  Group group,
                  short stockSize,
                  double unitPrice,
                  double discountRate,
                  short memoryGB,
                  short ramGB,
                  float monitorSize) {
        super(name, brand, group, stockSize, unitPrice, discountRate, memoryGB, ramGB, monitorSize);
    }
}
