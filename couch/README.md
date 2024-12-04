Views CouchDB

¡¡ Ultimas compras !! 
{
"_id": "_design/ultimasCompras",
"_rev": "1-baa5242d82d933bd93785b85ffa621d5",
"views": {
"ultimas_compras": {
"map": "function(doc) { if (doc.tipo === 'compra') { emit(doc.fechaDeCompra, doc); } }"
}
}
}

¡¡ COMPRAS !!
{
"_id": "_design/Compras",
"_rev": "13-07e7c06cc16209acfbaf7c66207c2e65",
"views": {
"compras_ultimo_mes": {
"map": "function(doc) { if (doc.fecha_compra && doc.fecha_compra > '2024-11-01') emit(doc.usuario_id, doc); }"
},
"compras_por_cliente": {
"map": "function(doc) { if (doc.type === 'compra') { emit(doc.id_cliente, 1); } }",
"reduce": "_sum"
}
}
}

¡¡ CLIENTES !!
{
"_id": "_design/Clientes",
"_rev": "1-24851645df81abdb8ca1a8361095f26d",
"views": {
"todos_clientes": {
"map": "function(doc) { if (doc.type === 'cliente') { emit(doc.idCliente, doc); } }"
}
}
}