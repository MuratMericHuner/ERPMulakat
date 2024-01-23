Birinci Mulakat cevaplari 
Butun cevpalar API olarak yanitlaidigm icin Butun class'lar entities kisminda ve butun
sorularin cevaplari ShipmentListServiceImpl'te bulabilirsiniz.
1) 
a) 
toplam tutar : 69621.41799999999

    public double getTotal() {
        List<ShipmentList> ShipmentList = shipmentListRepo.findAll();
        return ShipmentList.stream().mapToDouble(x-> (x.getQuantity()*x.getPrice())).reduce(Double::sum).orElse(0);
    }

Siparis 1000 toplam tutar : 34395.04
Siparis 1001 toplam tutar : 31427.578
Siparis 1002 toplam tutar : 3798.8

    public double getTotalById(Shipment shipment) {
        List<ShipmentList> ShipmentList = shipmentListRepo.findAll().stream().filter(x->x.getShipment().equals(shipment)).toList();
        return ShipmentList.stream().mapToDouble(x-> (x.getQuantity()*x.getPrice())).reduce(Double::sum).orElse(0);
    }

b)
butun mallarin ortalamasi : 135.18721941747572

    public double getAverage() {
        List<ShipmentList> ShipmentList = shipmentListRepo.findAll();
        int totalQuantity = ShipmentList.stream().map(ERPMulakat.ERPMulakat.Entities.ShipmentList::getQuantity).reduce(Integer::sum).orElse(0);
        return ShipmentList.stream().mapToDouble(x-> (x.getQuantity()*x.getPrice())).reduce(Double::sum).orElse(0)/totalQuantity;
    }

Siparis 1000 ortalamasi : 213.63378881987578
Siparis 1001 ortalamasi : 105.81676094276095
Siparis 1002 ortalamasi : 66.64561403508772

    public double getAverageById(Shipment shipment) {
        List<ShipmentList> ShipmentList = shipmentListRepo.findAll().stream().filter(x->x.getShipment().equals(shipment)).toList();
        int totalQuantity = ShipmentList.stream().map(ERPMulakat.ERPMulakat.Entities.ShipmentList::getQuantity).reduce(Integer::sum).orElse(0);
        return ShipmentList.stream().mapToDouble(x-> (x.getQuantity()*x.getPrice())).reduce(Double::sum).orElse(0)/totalQuantity;
    }
c)

Mal 2000 ortalamasi : 100.51
Mal 2001 ortalamasi : 85.03132773109243
Mal 2002 ortalamasi : 96.63450867052023
Mal 2003 ortalamasi : 203.35294117647058
Mal 2004 ortalamasi : 220.46136363636364
Mal 2005 ortalamasi : 44.1
Mal 2006 ortalamasi : 90.0

    public double getAverageProduct(Product product) {
        List<ShipmentList> ShipmentList = shipmentListRepo.findAll().stream().filter(x->x.getProduct().equals(product)).toList();
        int totalQuantity = ShipmentList.stream().map(ERPMulakat.ERPMulakat.Entities.ShipmentList::getQuantity).reduce(Integer::sum).orElse(0);
        return ShipmentList.stream().mapToDouble(x-> (x.getQuantity()*x.getPrice())).reduce(Double::sum).orElse(0)/totalQuantity;
    }
d)

Mal 2000:
        {
            "Shipment(shipmentId=1000)": 12
        }
Mal 2001:
        {
            "Shipment(shipmentId=1000)": 31,
            "Shipment(shipmentId=1001)": 88
        }
Mal 2002:
{
"Shipment(shipmentId=1000)": 22,
"Shipment(shipmentId=1001)": 135,
"Shipment(shipmentId=1002)": 16
}
Mal 2003:
{
"Shipment(shipmentId=1000)": 41,
"Shipment(shipmentId=1002)": 10
}
Mal 2004:
{
"Shipment(shipmentId=1000)": 55,
"Shipment(shipmentId=1001)": 74,
"Shipment(shipmentId=1002)": 3
}
Mal 2005:
{
"Shipment(shipmentId=1002)": 9
}
Mal 2006:
{
"Shipment(shipmentId=1002)": 19
}

    public Map<Shipment,Integer> getTotalProductQuantity(Product product) {
        List<ShipmentList> ShipmentList = shipmentListRepo.findAll().stream().filter(x->x.getProduct().equals(product)).toList();
        Map<Shipment,Integer> productQuantityInShipment = new HashMap<>();
        for (ERPMulakat.ERPMulakat.Entities.ShipmentList shipmentList : ShipmentList) {
            if (productQuantityInShipment.containsKey(shipmentList.getShipment())) {
                int quantity = productQuantityInShipment.get(shipmentList.getShipment());
                productQuantityInShipment.put(shipmentList.getShipment(), quantity+shipmentList.getQuantity());
            }else{
                productQuantityInShipment.put(shipmentList.getShipment(), shipmentList.getQuantity());
            }
        }
        return productQuantityInShipment;
    }

2)

Yeni 1003 no'lu siparis POST Request'i :
http://localhost:8082/shipment/save

body :
{
"shipmentId" : "1003"
}

response : 

{
"shipmentId": 1003
}

1003 no'lu siparisi ekledikten sonraki  butun siparisler icin GET requesti : 

http://localhost:8082/shipment/all

response : 

[
{
"shipmentId": 1000
},
{
"shipmentId": 1001
},
{
"shipmentId": 1002
},
{
"shipmentId": 1003
}
]